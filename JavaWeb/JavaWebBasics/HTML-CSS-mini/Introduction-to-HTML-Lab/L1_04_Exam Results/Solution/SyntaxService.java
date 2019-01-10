package com.hyperaspect.aurora.intelligence.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.io.IOUtils;
import org.aurora.intelligence.domain.AnalyzedText;
import org.aurora.intelligence.domain.Sentence;
import org.aurora.intelligence.domain.Word;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunking;
import com.aliasi.hmm.HiddenMarkovModel;
import com.aliasi.hmm.HmmDecoder;
import com.aliasi.tokenizer.IndoEuropeanTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.util.FastCache;
import com.hyperaspect.aurora.intelligence.dto.SyntacticalAnalysisResult;
import com.hyperaspect.aurora.intelligence.enumeration.LexicalCategory;
import com.hyperaspect.aurora.intelligence.enumeration.SyntaxEntity;
import com.hyperaspect.aurora.intelligence.helper.PhraseChunker;
import com.hyperaspect.commons.exception.InvalidBeanPassedForDBProcedure;

import edu.stanford.nlp.ie.machinereading.structure.MachineReadingAnnotations.GenderAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentenceIndexAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

/**
 * 
 * @author P.Pavlov
 *
 */
@Service
public class SyntaxService {

	@Value("${analyzerThreads}")
	private int analyzerThreads;

	@Autowired
	private DictionaryService dictionaryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(SyntaxService.class);

	private static final List<String> PUNCTUATIONAL_MARKS = Arrays
			.asList(new String[] { ".", "?", "!", ":", ";", "-", "—", "(", ")", "[", "]", "...", "“", "”", "/", "/" });;

	private StanfordCoreNLP coreNLP;
	private ExecutorService textExecutor;

	private String[] syntacitcalTags = new String[] { "CC", "CC", "DT", "EX", "FW", "IN", "JJ", "JJR", "JJS", "LS",
			"MD", "NN", "NNS", "NNP", "NNPS", "PDT", "POS", "PRP", "PRP$", "RB", "RBR", "RBS", "RP", "SYM", "TO", "UH",
			"VB", "VBD", "VBG", "VBN", "VBP", "VBZ", "WDT", "WP", "WP$", "WRB" };

	@PostConstruct
	public void setup() {
		Properties props = new Properties();
		props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref, sentiment");
		props.put("threads", "8");
		coreNLP = new StanfordCoreNLP(props);
		textExecutor = Executors.newFixedThreadPool(analyzerThreads);
	}

	@Deprecated
	private static PhraseChunker buildPhraseChunker() throws IOException, ClassNotFoundException {

		System.out.println(System.getProperty("java.class.path"));
		InputStream hmmStream = SyntaxService.class.getClassLoader()
				.getResourceAsStream("pos-en-general-brown.HiddenMarkovModel");

		File hmmFile = File.createTempFile("pos-en-general-brown", "HiddenMarkovModel");
		OutputStream outStream = new FileOutputStream(hmmFile);

		byte[] buffer = new byte[8 * 1024];
		int bytesRead;
		while ((bytesRead = hmmStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		IOUtils.closeQuietly(hmmStream);
		IOUtils.closeQuietly(outStream);

		int cacheSize = 5000;
		FastCache<String, double[]> cache = new FastCache<String, double[]>(cacheSize);

		// read HMM for pos tagging
		HiddenMarkovModel posHmm = null;

		posHmm = (HiddenMarkovModel) AbstractExternalizable.readObject(hmmFile);

		hmmFile.delete();

		HmmDecoder posTagger = new HmmDecoder(posHmm, null, cache);
		TokenizerFactory tokenizerFactory = new IndoEuropeanTokenizerFactory();
		return new PhraseChunker(posTagger, tokenizerFactory);
	}

	/**
	 * Executes syntactical analysis procedure which separates the noun and verb
	 * phrases from the provided text.
	 * 
	 * @param text
	 *            that will be analyzed
	 */
	@Deprecated
	private SyntacticalAnalysisResult syntacticalAnalysisOld(String text) {
		SyntacticalAnalysisResult result = new SyntacticalAnalysisResult();
		if (text != null) {

			try {

				PhraseChunker chunker = buildPhraseChunker();

				Chunking chunking = chunker.chunk(text);
				CharSequence cs = chunking.charSequence();
				LOGGER.info("\n" + cs);
				for (Chunk chunk : chunking.chunkSet()) {
					handleChunk(result, chunk, cs);
				}

			} catch (IOException e) {
				LOGGER.error("Exception reading model=" + e.getMessage(), e);
			} catch (ClassNotFoundException e) {
				LOGGER.error("Exception reading model=" + e.getMessage(), e);
			}

			// construct chunker
		}

		return result;
	}

	public List<Word> NERAnalysis(String text) {
		List<Word> result = new ArrayList<Word>();
		Annotation document = new Annotation(text);
		coreNLP.annotate(document);
		List<CoreMap> coreSentences = document.get(SentencesAnnotation.class);

		int sentenceCounter = 0;
		coreSentences.parallelStream().forEach(cs -> {
			LOGGER.debug("processing sentence " + sentenceCounter);
			Tree tree = cs.get(SentimentCoreAnnotations.AnnotatedTree.class);

			for (CoreLabel token : cs.get(TokensAnnotation.class)) {
				String wordValue = token.get(TextAnnotation.class);
				String ne = token.get(NamedEntityTagAnnotation.class);
				Word word = new Word();

				word.setValue(wordValue);
				word.setNamedEntityType(ne);
				result.add(word);
			}

		});

		return result;
	}

	public AnalyzedText analyze(String text) throws InvalidBeanPassedForDBProcedure, InterruptedException {
		return analyze(text, new ArrayList<>(), null);
	}

	public AnalyzedText analyze(String text, List<org.aurora.intelligence.domain.Annotation> customAnnotations,
			String statementId) throws InvalidBeanPassedForDBProcedure, InterruptedException {
		// custom anotaciqta ako ima takava da se zapisva v bazata otdelno ot redisa za
		// da ne hvyr4at naprazno strukturi s noudove po redisa
		// i se vzima tuk po id

		text = text.replaceAll("/[^A-Za-z0-9]/", "");
		text = text.replaceAll("\\*", "");
		LOGGER.info("new text : " + text);
		String nounPhrasesPattern = "((?:\\([^\\(\\)\\s]+\\sDT\\))*?)((?:\\([^\\(\\)\\s]+\\sJJ[RS]?\\)|\\([^\\(\\)\\s]+\\sNN[SP]?S?\\))*)((?:\\([^\\(\\)\\s]+\\sIN\\))?)((?:\\([^\\(\\)\\s]+\\sDT\\))*?)((?:\\([^\\(\\)\\s]+\\sJJ[RS]?\\)|\\([^\\(\\)\\s]+\\sNN[SP]?S?\\))*)((?:\\([^\\(\\)\\s]+\\sDT\\))*?)(\\([^\\(\\)\\s]+\\sNN[SP]?S?\\))";
		String verbPhrasesPattern = "((?:\\([^\\(\\)\\s]+\\sVB[GDN]?\\)|\\([^\\(\\)\\s]+\\sRB\\))*)((?:\\([^\\(\\)\\s]+\\sIN\\))?)((?:\\([^\\(\\)\\s]+\\sVB[GDN]?\\)|\\([^\\(\\)\\s]+\\sRB\\))+)";

		AnalyzedText result = new AnalyzedText();
		List<Sentence> sentences = new ArrayList<>();

		Annotation document = new Annotation(text);
		coreNLP.annotate(document);
		List<CoreMap> coreSentences = document.get(SentencesAnnotation.class);

		CountDownLatch latch = new CountDownLatch(coreSentences.size());
		coreSentences.forEach(cs -> {
			textExecutor.submit(new Runnable() {
				@Override
				public void run() {

					Sentence sentence = new Sentence();
					List<Word> words = new ArrayList<>();
					String strSentence = "";

					Tree tree = cs.get(SentimentCoreAnnotations.AnnotatedTree.class);

					int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
					sentence.setSentimentScore(sentiment);
					sentence.setIndex(cs.get(SentenceIndexAnnotation.class));

					String syntacticProjection = "(";

					long startTime = System.currentTimeMillis();

					List<CoreLabel> tokens = new ArrayList<>();
					for (CoreLabel token : cs.get(TokensAnnotation.class)) {
						tokens.add(token);
					}

					long endTime = System.currentTimeMillis();
					LOGGER.info("Tokenization for " + statementId + " took " + (double) (endTime - startTime) / 1000
							+ " seconds");

					for (int i = 0; i < tokens.size(); i++) {
						CoreLabel token = tokens.get(i);

						String wordValue = token.get(TextAnnotation.class);
						strSentence += wordValue + " ";

						String ne = token.get(NamedEntityTagAnnotation.class);
						String pos = token.get(PartOfSpeechAnnotation.class);
						String gender = token.get(GenderAnnotation.class);
						Word word = new Word();
						if (gender != null) {
							word.setGender(gender);
						}
						word.setValue(wordValue);
						word.setNamedEntityType(ne);
						word.setLexicalCategory(LexicalCategory.getInstanceFromCodeValue(pos));
						words.add(word);
						syntacticProjection += "(" + wordValue + " " + pos + ")";
					}

					LOGGER.info("Processing sentence " + strSentence + " for " + statementId);
					syntacticProjection += ")";

					sentence.setWords(words);
					sentence.setNounPhrases(extractPhrases(nounPhrasesPattern, syntacticProjection, 8));
					sentence.setVerbPhrases(extractPhrases(verbPhrasesPattern, syntacticProjection, 4));

					String sentenceString = cs.get(TextAnnotation.class);
					for (org.aurora.intelligence.domain.Annotation customAnnotation : customAnnotations) {

						if (customAnnotation.getPattern() == null || customAnnotation.getPattern().equals("")) {
							continue;
						}
						Pattern pattern = Pattern.compile(customAnnotation.getPattern(), Pattern.CASE_INSENSITIVE);

						Matcher matcher = pattern.matcher(sentenceString);

						while (matcher.find()) {
							String matchGroup = matcher.group(1);
							for (String matchedWord : matchGroup.split(" ")) {
								for (int j = 0; j < words.size(); j++) {
									Word w = words.get(j);
									boolean previousWordMatches = j > 0
											&& matchedWord.contains(words.get(j - 1).getValue());
									boolean nextWordMatches = j < words.size() - 1
											&& matchedWord.contains(words.get(j + 1).getValue());
									boolean wordLength = w.getValue().length() > 1;
									boolean wordsAreEqual = w.getValue().equals(matchedWord);
									boolean separatedWordsMatch = matchedWord.contains(w.getValue())
											&& (previousWordMatches || nextWordMatches);
									if (wordLength && (wordsAreEqual || separatedWordsMatch)) {
										w.setNamedEntityType(customAnnotation.getKey());
									}
								}
							}
						}
					}

					try {
						startTime = System.currentTimeMillis();
						sentence.setFrequencyAnalysis(dictionaryService.frequencyAnalysis(strSentence.trim(),
								sentence.getNounsAssembledPhrases(), sentence.getVerbsAssembledPhrases()));

						endTime = System.currentTimeMillis();
						LOGGER.info("Frequency analysys for " + statementId + " took "
								+ (double) (endTime - startTime) / 1000 + " seconds");
					} catch (Exception e) {
						LOGGER.error("Freqency analysis for " + statementId + "failed");
					}

					LOGGER.info(statementId + " has " + String.valueOf(coreSentences.size() - latch.getCount() + 1)
							+ " / " + coreSentences.size());
					latch.countDown();
					sentences.add(sentence);

				}
			});

		});

		try {
			latch.await();
			LOGGER.info("Processing sentences done");
			result.setSentences(sentences);

			return result;
		} catch (InterruptedException e) {
			throw e;
		}

	}

	private List<List<List<String>>> extractPhrases(String pattern, String syntacticProjection, int groups) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(syntacticProjection);
		List<List<List<String>>> result = new ArrayList<>();
		while (m.find()) {

			List<List<String>> completePhrase = new ArrayList<>();
			for (int i = 1; i < groups; i++) {
				String phrase = m.group(i);
				if (phrase != null && !phrase.isEmpty()) {

					phrase = phrase.replaceAll("\\(", "");

					String[] chunks = phrase.split("\\)");

					for (String chunk : chunks) {

						List<String> word = Arrays.asList(chunk.split(" "));
						completePhrase.add(word);
					}

				}
			}

			result.add(completePhrase);
		}

		return result;
	}

	/**
	 * Handles a single chunk resulted from part of speach tagging and populates the
	 * founded verb or noun phrases into the {@link SyntacticalAnalysisResult}
	 * 
	 * @param result
	 *            {@link SyntacticalAnalysisResult}
	 * @param chunk
	 *            {@link Chunk}
	 * @param cs
	 *            {@link CharSequence}
	 */
	private void handleChunk(SyntacticalAnalysisResult result, Chunk chunk, CharSequence cs) {
		String type = chunk.type();
		int start = chunk.start();
		int end = chunk.end();
		CharSequence seq = cs.subSequence(start, end);

		LOGGER.debug("  " + type + "(" + start + "," + end + ") " + seq);

		Annotation document = new Annotation(seq.toString());
		coreNLP.annotate(document);

		List<CoreMap> sentences = document.get(SentencesAnnotation.class);

		List<List<String>> phrase = new ArrayList<>();

		for (CoreMap sentence : sentences) {

			for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
				// this is the text of the token
				String word = token.get(TextAnnotation.class);
				// this is the POS tag of the token
				String pos = token.get(PartOfSpeechAnnotation.class);

				List<String> taggedWord = new ArrayList<>();
				taggedWord.add(word);
				taggedWord.add(pos);

				phrase.add(taggedWord);
			}
		}

		switch (SyntaxEntity.getInstanceFromCodeValue(type)) {
		case VERB:
			result.addVerbPhrase(phrase);
			break;
		case NOUN:
			result.addNounPhrase(phrase);
			break;
		default:
			break;
		}
	}

	// TODO: IMPROVE punctuation clear
	public static String clearPunctuation(String text) {
		return text.replaceAll("[^a-zA-Z ]", "");
	}

}

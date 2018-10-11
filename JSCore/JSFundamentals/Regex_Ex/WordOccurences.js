function wordOccurances(text, word) {
    const regex = new RegExp(`\\b${word}\\b`, 'gi');
    const matches = text.match(regex) || [];
    console.log(matches.length);
}

wordOccurances('The waterfall was so high, that the child couldn’t see its peak.',
'the'
);

wordOccurances('How do you plan on achieving that? How? How can you even think of that?', 
'how'
);

wordOccurances('sdada', 'kur');
package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "" +
            "C:\\Coding\\SoftUni\\JavaDB\\" +
            "DatabaseAdvancedFrameworks\\" +
            "SpringDataAdvancedQueringEx\\src\\" +
            "main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CategoryRepository categoryRepository,
                           FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil
                .getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType
                    .values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate
                    .parse(lineParams[1],
                            DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction
                    .values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository
                .findAllByReleaseDateAfter(LocalDate
                        .parse("2000-12-31"));

        return books.stream().map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository
                .findAllByReleaseDateBefore(LocalDate
                        .parse("1990-01-01"));

        return books.stream().map(b -> String
                .format("%s %s",
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()))
                .collect(Collectors.toSet());
    }

    @Override
    public List<String> getBookTitleByAgeRestriction(AgeRestriction ageRestriction) {
        return this.bookRepository
                .findAllByAgeRestrictionIs(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitleOfGoldenEditionBookWithLessThen5000Copies() {
        return this.bookRepository
                .findAllByEditionTypeIsAndCopiesLessThan(EditionType.GOLD, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getBookTitleAndPriceForBooksWithPriceUnder5AndHigherThan40() {
        return this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(
                        BigDecimal.valueOf(5),
                        BigDecimal.valueOf(40))
                .stream()
                .map(book -> String.format(
                        "%s - $%.2f",
                        book.getTitle(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> notReleasedBooks(String yearAsString) {
        LocalDate before = LocalDate.parse(yearAsString + "-01-01");
        LocalDate after = LocalDate.parse(yearAsString + "-12-31");

        return this.bookRepository
                .findAllByReleaseDateBeforeOrReleaseDateAfter(
                        before,
                        after)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksReleasedBeforeDate(String dateAsString) {
        LocalDate before = LocalDate.parse(dateAsString,
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository
                .findAllByReleaseDateBefore(before)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksSearch(String text) {
        return this.bookRepository
                .findAllByTitleContains(text)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> bookTitlesSearch(String lastNameStartWithString) {
        List<Author> authors = this.authorRepository
                .findAllByLastNameStartingWith(lastNameStartWithString);
        return this.bookRepository
                .findAllByAuthorIsIn(authors)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer countBooks(int length) {
        return this.bookRepository
                .countBooks(length);
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random
                .nextInt((int) (this.authorRepository
                        .count() - 1)) + 1;

        return this.authorRepository
                .findById(randomId)
                .orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random
                .nextInt((int) (this
                        .categoryRepository.count() - 1)) + 1;

        return this.categoryRepository
                .findById(randomId)
                .orElse(null);
    }
}
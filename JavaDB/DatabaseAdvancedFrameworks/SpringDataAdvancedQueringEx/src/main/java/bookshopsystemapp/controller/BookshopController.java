package bookshopsystemapp.controller;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;
    private static Scanner scanner;

    @Autowired
    public BookshopController(AuthorService authorService,
                              CategoryService categoryService,
                              BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();
        this.booksTitlesByAgeRestriction();
    }

    /**
     * Task 1: Books Titles by Age Restriction
     */
    private void booksTitlesByAgeRestriction(){
        String input = scanner.nextLine().toUpperCase();
        AgeRestriction ageRestriction = AgeRestriction
                .valueOf(input);
        this.bookService
                .getBookTitleByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    /**
     * Task 2: Golden Books
     */

    private void goldedBooks(){
        this.bookService
                .getBookTitleOfGoldenEditionBookWithLessThen5000Copies()
                .forEach(System.out::println);
    }

    /**
     * Task 3: Books By Price
     */
    private void booksByPrice(){
        this.bookService
                .getBookTitleAndPriceForBooksWithPriceUnder5AndHigherThan40()
                .forEach(System.out::println);
    }

    /**
     * Task 4: Not Released Books
     */
    private void notReleasedBooks(){
        String yearAsString = scanner.nextLine();

        this.bookService
                .notReleasedBooks(yearAsString)
                .forEach(System.out::println);
    }

    /**
     * Task 5: Books Released Before Date
     */
    private void booksReleasedBeforeDate(){
        String dateAsString = scanner.nextLine();

        this.bookService
                .booksReleasedBeforeDate(dateAsString)
                .forEach(System.out::println);
    }

    /**
     * Task 6: Authors Search
     */
    private void authorsSearch(){
        String endString = scanner.nextLine();

        this.authorService
                .authorsSearch(endString)
                .forEach(System.out::println);
    }

    /**
     * Task 7: Books Search
     */
    private void bookSearch(){
        String text = scanner.nextLine();

        this.bookService
                .booksSearch(text)
                .forEach(System.out::println);
    }

    /**
     * Task 8: Book Titles Search
     */
    private void bookTitlesSearch(){
        String lastNameStartWithString = scanner.nextLine();

        this.bookService
                .bookTitlesSearch(lastNameStartWithString)
                .forEach(System.out::println);
    }

    /**
     * Task 9: Count Books
     */
    private void countBooks(){
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.countBooks(number));
    }

    /**
     * Task 10: Took Book Copies
     */
    private void totalBookCopies(){
        this.authorService
                .totalBookCopies()
                .forEach(System.out::println);
    }
}
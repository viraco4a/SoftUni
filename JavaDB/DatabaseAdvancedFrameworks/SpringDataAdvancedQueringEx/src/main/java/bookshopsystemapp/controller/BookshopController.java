package bookshopsystemapp.controller;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
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
        this.booksReleasedBeforeDate();
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
}
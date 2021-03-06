package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.AgeRestriction;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getBookTitleByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getBookTitleOfGoldenEditionBookWithLessThen5000Copies();

    List<String> getBookTitleAndPriceForBooksWithPriceUnder5AndHigherThan40();

    List<String> notReleasedBooks(String yearAsString);

    List<String> booksReleasedBeforeDate(String dateAsString);

    List<String> booksSearch(String text);

    List<String> bookTitlesSearch(String lastNameStartWithString);

    Integer countBooks(int length);
}

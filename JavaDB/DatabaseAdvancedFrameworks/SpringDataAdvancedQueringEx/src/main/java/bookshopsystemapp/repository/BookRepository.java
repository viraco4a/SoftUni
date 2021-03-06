package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestrictionIs(final AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeIsAndCopiesLessThan(
            final EditionType editionType, final int copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(
            final BigDecimal lowerThanPrice,
            final BigDecimal higherThanPrice);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(
            LocalDate before,
            LocalDate after);

    List<Book> findAllByTitleContains(String text);

    List<Book> findAllByAuthorIsIn(final List<Author> authors);

    @Query("" +
            "SELECT COUNT(b) " +
            "FROM bookshopsystemapp.domain.entities.Book as b " +
            "WHERE LENGTH(b.title) > :length")
    Integer countBooks(@Param(value = "length") final int length);


}

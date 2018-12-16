package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("" +
            "SELECT a " +
            "FROM bookshopsystemapp.domain.entities.Author AS a " +
            "WHERE a.firstName " +
            "LIKE :wildCard")
    List<Author> authorFirstNameEndsWith(
            @Param(value = "wildCard") String wildCard);

    List<Author> findAllByLastNameStartingWith(String startString);

    @Query("" +
            "SELECT CONCAT(a.firstName, ' ', a.lastName, ' - ', SUM(b.copies)) " +
            "FROM bookshopsystemapp.domain.entities.Author AS a " +
            "JOIN bookshopsystemapp.domain.entities.Book AS b " +
            "GROUP BY a.id " +
            "ORDER BY SUM(b.copies) DESC ")
    List<Object> getAuthorsByBooksCopies();
}

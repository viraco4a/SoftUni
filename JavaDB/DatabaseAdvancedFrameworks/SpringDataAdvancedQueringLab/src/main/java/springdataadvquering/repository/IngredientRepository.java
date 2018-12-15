package springdataadvquering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdataadvquering.domain.entities.Ingredient;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String startLetter);

    List<Ingredient> findAllByNameInOrderByPriceAsc(final Collection<String> name);

    Set<Ingredient> findAllByNameIn(final Collection<String> names);

    @Modifying
    @Transactional
    @Query("" +
            "DELETE FROM springdataadvquering.domain.entities.Ingredient AS i " +
            "WHERE i.name = :name")
    void deleteIngredientByName(@Param(value = "name") String ingredientName);

    @Modifying
    @Transactional
    @Query("" +
            "UPDATE springdataadvquering.domain.entities.Ingredient AS b " +
            "SET b.price = b.price * 1.1")
    void increaseAllIngredientsPriceBy10Percents();

    @Modifying
    @Transactional
    @Query("UPDATE springdataadvquering.domain.entities.Ingredient AS b " +
            "SET b.price = b.price * 1.1 " +
            "WHERE b.name IN :names")
    void increaseIngredientsPriceBy10PercentsFromList(
            @Param("names") List<String> ingredientNames);
}

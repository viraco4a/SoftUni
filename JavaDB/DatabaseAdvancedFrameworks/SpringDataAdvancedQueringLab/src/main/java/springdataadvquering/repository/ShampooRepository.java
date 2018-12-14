package springdataadvquering.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springdataadvquering.domain.entities.Ingredient;
import springdataadvquering.domain.entities.Shampoo;
import springdataadvquering.domain.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabel_IdOrderByPriceAsc(Size size, long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal minPrice);

    Integer countAllByPriceLessThan(BigDecimal maxPrice);

    @Query("" +
            "SELECT s FROM springdataadvquering.domain.entities.Shampoo AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i IN :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);
}

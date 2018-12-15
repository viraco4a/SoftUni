package springdataadvquering.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<String> selectShampooBySize(String inputSize);

    List<String> selectShampoosBySizeOrLabel(String inputSize, long labelId);

    List<String> selectShampoosBiggerThanPrice(BigDecimal minPrice);

    Integer countShampoosWithPriceBiggerThan(BigDecimal maxPrice);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);

    List<String> selectShampoosByIngredientsCount(int number);

    BigDecimal SelectIngredientPricesByShampooBrand(String brand);
}

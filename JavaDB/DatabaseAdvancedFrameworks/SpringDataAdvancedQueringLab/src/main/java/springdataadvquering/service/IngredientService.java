package springdataadvquering.service;

import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsByStartLetter(String startLetter);

    List<String> selectIngredientsContainedInList(List<String> name);

    void deleteIngredientByName(String ingredientName);
    void increaseAllIngredientsPrice();
    void increaseIngredientsPriceFromList(List<String> ingredientNames);
}

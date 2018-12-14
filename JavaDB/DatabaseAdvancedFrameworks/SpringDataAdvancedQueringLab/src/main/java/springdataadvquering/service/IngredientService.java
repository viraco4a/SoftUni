package springdataadvquering.service;

import java.util.Collection;
import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsByStartLetter(String startLetter);

    List<String> selectIngredientsContainedInList(List<String> name);
}

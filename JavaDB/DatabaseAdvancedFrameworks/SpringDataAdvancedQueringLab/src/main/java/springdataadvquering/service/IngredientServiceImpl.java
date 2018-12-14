package springdataadvquering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvquering.domain.entities.Ingredient;
import springdataadvquering.repository.IngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectIngredientsByStartLetter(String startLetter) {
        List<Ingredient> ingredients = this.ingredientRepository
                .findAllByNameStartingWith(startLetter);

        return ingredients
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectIngredientsContainedInList(List<String> name) {
        List<Ingredient> ingredients = this.ingredientRepository
                .findAllByNameInOrderByPriceAsc(name);

        return ingredients
                .stream()
                .map(Ingredient::getName)
                .collect(Collectors.toList());
    }
}

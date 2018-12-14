package springdataadvquering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdataadvquering.domain.entities.Ingredient;
import springdataadvquering.domain.entities.Shampoo;
import springdataadvquering.domain.entities.Size;
import springdataadvquering.repository.IngredientRepository;
import springdataadvquering.repository.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository,
                              IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectShampooBySize(String inputSize) {
        Size size = Size.valueOf(inputSize.toUpperCase());
        List<Shampoo> shampoos = this.shampooRepository
                .findAllBySizeOrderById(size);

        return getCollect(shampoos);
    }

    @Override
    public List<String> selectShampoosBySizeOrLabel(String inputSize, long labelId) {
        Size size = Size.valueOf(inputSize.toUpperCase());
        List<Shampoo> shampoos = this.shampooRepository
                .findAllBySizeOrLabel_IdOrderByPriceAsc(size, labelId);

        return getCollect(shampoos);
    }

    @Override
    public List<String> selectShampoosBiggerThanPrice(BigDecimal minPrice) {
        List<Shampoo> shampoos = this.shampooRepository
                .findAllByPriceGreaterThanOrderByPriceDesc(minPrice);

        return getCollect(shampoos);
    }

    @Override
    public Integer countShampoosWithPriceBiggerThan(BigDecimal maxPrice) {

        return this.shampooRepository.countAllByPriceLessThan(maxPrice);
    }

    @Override
    public List<String> selectShampoosByIngredients(List<String> ingredientNames) {
        Set<Ingredient> ingredients = this.ingredientRepository
                .findAllByNameIn(ingredientNames);

        List<Shampoo> shampoos = this.shampooRepository
                .findByIngredientsIn(ingredients);

        return shampoos
                .stream()
                .map(Shampoo::getBrand)
                .collect(Collectors.toList());
    }

    private List<String> getCollect(List<Shampoo> shampoos) {
        return shampoos
                .stream()
                .map(s ->
                        String.format("%s %s %.2flv.",
                                s.getBrand(),
                                s.getSize(),
                                s.getPrice())
                ).collect(Collectors.toList());
    }
}

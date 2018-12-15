package springdataadvquering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springdataadvquering.service.IngredientService;
import springdataadvquering.service.ShampooService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;
    private static Scanner scanner;

    @Autowired
    public AppController(ShampooService shampooService,
                         IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        scanner = new Scanner(System.in);
        this.selectShampoosBySIzeOrLabel();
    }

    /**
     * Task 1: Select Shampoos by Size
     */
    private void selectShampoosBySIzeOrLabel() {
        String inputSize = scanner.nextLine();
        long labelId = Long.parseLong(scanner.nextLine());
        List<String> result = this.shampooService
                .selectShampoosBySizeOrLabel(inputSize, labelId);
        result.forEach(System.out::println);
    }

    /**
     * Task 2: Select Shampoos by Size or Label
     */
    private void selectShampooBySize() {
        String inputSize = scanner.nextLine();
        List<String> result = this.shampooService
                .selectShampooBySize(inputSize);
        result.forEach(System.out::println);
    }

    /**
     * Task 3: Select Shampoos by Price
     */
    private void selectShampooByPrice(){
        BigDecimal minPrice = new BigDecimal(scanner.nextLine());
        List<String> result = this.shampooService
                .selectShampoosBiggerThanPrice(minPrice);
        result.forEach(System.out::println);
    }

    /**
     * Task 4: Select Ingredients by Name
     */
    private void selectIngredientsByName(){
        String startLetter = scanner.nextLine();
        List<String> result = this.ingredientService
                .selectIngredientsByStartLetter(startLetter);
        result.forEach(System.out::println);
    }

    /**
     * Task 5: Select Ingredients by Names
     */
    private void selectIngredientsByNames(){
        List<String> names = new ArrayList<>();
        String name = scanner.nextLine();

        while (!name.equals("")){
            names.add(name);
            name = scanner.nextLine();
        }
        List<String> result = this.ingredientService
                .selectIngredientsContainedInList(names);
        result.forEach(System.out::println);
    }

    /**
     * Task 6: Count Shampoos by Price
     */
    private void countShampoosByPrice(){
        BigDecimal maxPrice = new BigDecimal(scanner.nextLine());
        int result = this.shampooService
                .countShampoosWithPriceBiggerThan(maxPrice);
        System.out.println(result);
    }

    /**
     * Task 7: Select Shampoos By Ingredients
     */
    private void selectShampoosByIngredients(){
        String line = scanner.nextLine();
        List<String> lines = new ArrayList<>();
        while (!"".equals(line)){
            lines.add(line);
            line = scanner.nextLine();
        }

        List<String> result = this.shampooService
                .selectShampoosByIngredients(lines);
        result.forEach(System.out::println);
    }

    /**
     * Task 8: Select Shampoos By Ingredients Count
     */
    private void selectShampoosByIngredientsCount(){
        int number = Integer.parseInt(scanner.nextLine());
        List<String> result = this.shampooService
                .selectShampoosByIngredientsCount(number);
        result.forEach(System.out::println);
    }

    /**
     * Task 9: Select Ingredient Name and SHampoo Brand By Name
     */
    private void selectIngredientNameAndShampooBrandByName(){
        String brand = scanner.nextLine();
        BigDecimal result = this.shampooService
                .SelectIngredientPricesByShampooBrand(brand);
        System.out.println(result);
    }

    /**
     * Task 10: Delete Ingredients by name
     */
    private void deleteIngredientsByName(){
        String ingredientToDelete = scanner.nextLine();
        this.ingredientService.deleteIngredientByName(ingredientToDelete);
    }

    /**
     * Task 11: Delete Ingredients by name
     */
    private void updateIngredientsByPrice(){
        this.ingredientService.increaseAllIngredientsPrice();
    }

    /**
     * Task 12: Delete Ingredients by name
     */
    private void updateIngredientsByNames(){
        List<String> ingredients = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("")){
            ingredients.add(input);
            input = scanner.nextLine();
        }
        this.ingredientService
                .increaseIngredientsPriceFromList(ingredients);
    }
}

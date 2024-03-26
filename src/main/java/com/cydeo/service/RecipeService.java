package com.cydeo.service;

import com.cydeo.QuantityType;
import com.cydeo.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeService(RecipeRepository recipeRepository, ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }

    public Recipe prepareRecipe(){
        UUID id = UUID.randomUUID();
        String name = faker.food().dish();
        String preparation = faker.lorem().paragraph(5);
        long duration = faker.number().randomNumber();

        List<Ingredient> ingredients = getIngredients();

        RecipeType recipeType = RecipeType.BAKED.randomRecipeType();

        Recipe recipe = new Recipe(id, name, duration, preparation, ingredients, recipeType);
        System.out.println(recipe);

        recipeRepository.saveRecipe(recipe);
        shareService.shareRecipe(recipe);

        return recipe;

    }

    private List<Ingredient> getIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int quantity = faker.number().randomDigit();
            String ingredientName = faker.food().ingredient();
            QuantityType quantityType = QuantityType.LB.randomQuantityType();
            Ingredient ingredient = new Ingredient(ingredientName,quantity, quantityType);
            ingredients.add(ingredient);
        }
        return ingredients;
    }


}

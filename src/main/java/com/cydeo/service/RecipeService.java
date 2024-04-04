package com.cydeo.service;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
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

        List<Ingredient> ingredients = getIngredients();

        RecipeType recipeType = RecipeType.BAKED.randomRecipeType();

        Recipe recipe = new Recipe(UUID.randomUUID(), faker.food().dish(), faker.number().randomNumber(), faker.lorem().paragraph(5), ingredients, recipeType);
        System.out.println(recipe);

        recipeRepository.saveRecipe(recipe);
        shareService.shareRecipe(recipe);

        return recipe;

    }

    private List<Ingredient> getIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Ingredient ingredient = new Ingredient(faker.food().ingredient(),faker.number().randomDigit(), QuantityType.LB.randomQuantityType());
            ingredients.add(ingredient);
        }
        return ingredients;
    }


}

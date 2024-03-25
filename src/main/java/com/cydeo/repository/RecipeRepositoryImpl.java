package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository{

    private List<Recipe> recipesList = new ArrayList<>();

    @Override
    public void saveRecipe(Recipe recipe) {
        recipesList.add(recipe);
        System.out.println("added to database");
    }
}

package com.cydeo.service;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

@Component
public class InstagramShareServiceImpl implements ShareService{
    @Override
    public void shareRecipe(Recipe recipe) {
        System.out.println(recipe.getName());
        System.out.println(recipe.getRecipeType());
        System.out.println(recipe.getIngredients());
    }
}

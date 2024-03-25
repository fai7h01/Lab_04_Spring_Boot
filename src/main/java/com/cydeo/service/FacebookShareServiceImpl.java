package com.cydeo.service;

import com.cydeo.model.Recipe;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FacebookShareServiceImpl implements ShareService{
    @Override
    public void shareRecipe(Recipe recipe) {
        System.out.println(recipe.getName());
        System.out.println(recipe.getRecipeType());
        System.out.println(recipe.getIngredients());
        System.out.println("Shared on facebook");
    }
}

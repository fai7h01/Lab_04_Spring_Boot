package com.cydeo;

import java.util.Random;

public enum RecipeType {
    BREAKFAST, LUNCH, DESSERT, APPETIZER, BAKED, SOUP, VEGETARIAN;

    public RecipeType randomRecipeType(){
        int pick = new Random().nextInt(RecipeType.values().length);
        return RecipeType.values()[pick];
    }
}

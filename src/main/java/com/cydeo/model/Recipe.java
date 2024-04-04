package com.cydeo.model;

import com.cydeo.enums.RecipeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@ToString
public class Recipe {

    private UUID id;
    private String name;
    private long duration;
    private String preparation;
    private List<Ingredient> ingredients;
    private RecipeType recipeType;

}

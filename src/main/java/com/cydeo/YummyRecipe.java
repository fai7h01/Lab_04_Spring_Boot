package com.cydeo;

import com.cydeo.service.RecipeService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YummyRecipe {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(YummyRecipe.class, args);

        RecipeService recipeService = context.getBean(RecipeService.class);
        recipeService.prepareRecipe();

    }


    @Bean
    Faker faker(){
        return new Faker();
    }
}

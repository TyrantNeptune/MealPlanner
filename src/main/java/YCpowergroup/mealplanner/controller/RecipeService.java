package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    RecipeService(){
        System.out.println("RecipeService");
    }

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();

    }

    public Iterable<Recipe> findRecipeByName() {
        return null;
    }
}

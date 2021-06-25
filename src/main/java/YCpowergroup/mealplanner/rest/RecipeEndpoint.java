package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeEndpoint {

    @Autowired
    RecipeService recipeService;

    @GetMapping("all-recipes")
    public Iterable<Recipe> allRecipes() {
        return recipeService.getAllRecipes();
    }

    /*
    @GetMapping("found-recipe")
    public Recipe foundRecipe() { return recipeService.findRecipeByName();}
     */


}

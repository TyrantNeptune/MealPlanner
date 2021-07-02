package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.NutritionValues;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
import YCpowergroup.mealplanner.domain.meal.Meal;
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

    @GetMapping("found-recipes/{zoekterm}")
    public Iterable<Recipe> foundRecipe(@PathVariable String zoekterm) {
        return recipeService.findRecipeByName(zoekterm);
    }

    @PostMapping("addrecipe")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @PostMapping("addmeal")
    public void addMeal(@RequestBody Meal meal){
        System.out.println(recipeService.checkIfMealExists(meal));
    }

//    @PostMapping("abc")
//    public void checkit(@RequestBody Rdto checkit) {
//        NutritionValues nv = new NutritionValues();
//        nv.setCalories(checkit.getA());
//        Recipe recipe = new Recipe();
//        RecipeIngredient recipeIngredient = new RecipeIngredient();
//        recipeIngredient.setRecipe(recipe);
//    }





}

package YCpowergroup.mealplanner.oud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecipeEndpointDeprecated {

    @Autowired
    RecipeServiceDeprecated recipeService;

    @GetMapping("all-recipes")
    public Iterable<RecipeDeprecated> allRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("found-recipes/{zoekterm}")
    public Iterable<RecipeDeprecated> foundRecipe(@PathVariable String zoekterm) {
        return recipeService.findRecipeByName(zoekterm);
    }

    @PostMapping("addrecipe")
    public RecipeDeprecated addRecipe(@RequestBody RecipeDeprecated recipeDeprecated) {
        System.out.println(recipeDeprecated.getNutritionValuesPerServing());
        return recipeService.saveRecipe(recipeDeprecated);
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

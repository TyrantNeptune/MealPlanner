package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.NutritionValues;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Iterable<Recipe> findRecipeByName(String zoekterm) {
        return recipeRepository.findAllByNameContaining(zoekterm);
    }

    public Recipe saveRecipe(Recipe recipe) {
        System.out.println("binnen" + recipe.getName());
        return recipeRepository.save(recipe);
    }
}

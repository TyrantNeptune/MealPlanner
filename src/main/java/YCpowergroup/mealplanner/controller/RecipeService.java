package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.MealType;
import YCpowergroup.mealplanner.domain.NutritionValues;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.meal.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    MealRepository mealRepository;

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

    public boolean checkIfMealExists(Meal meal){
        MealType mealType = meal.getMealType();
        LocalDate date = meal.getDate();
        mealRepository.findMealByMealTypeAndDate(mealType, date);
        return true;
    }
}

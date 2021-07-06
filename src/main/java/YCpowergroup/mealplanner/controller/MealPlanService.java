package YCpowergroup.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;

public class MealPlanService {
    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    RecipeRepository recipeRepository;



}

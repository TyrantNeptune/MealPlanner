package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealPlanService {
    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public Iterable<MealPlan> findAllMealPlans(){return mealPlanRepository.findAll();}

    public MealPlan addMealPlan(MealPlan mealPlan){
        System.out.println("Adding new mealplan...");
        return mealPlanRepository.save(mealPlan);
    }

}

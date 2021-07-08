package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.MealPlanService;
import YCpowergroup.mealplanner.domain.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlanEndpoint {
    @Autowired
    MealPlanService mealPlanService;

    @GetMapping("allmealplans")
    public Iterable<MealPlan> allMealPlans(){
        System.out.println("Finding all mealplans...");
        return mealPlanService.findAllMealPlans();
    }

}

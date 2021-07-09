package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.MealPlanService;
import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class MealPlanEndpoint {
    @Autowired
    MealPlanService mealPlanService;

    @GetMapping("findmealplanbyid/{mealplanid}")
    public Optional<MealPlan> findMealPlanById(@PathVariable long mealplanid){
        System.out.println("Finding mealplan with id: "+mealplanid);
        return mealPlanService.findMealPlanById(mealplanid);
    }

    @GetMapping("allmealplans")
    public Iterable<MealPlan> allMealPlans(){
        System.out.println("Finding all mealplans...");
        return mealPlanService.findAllMealPlans();
    }

    @PostMapping("addmealplan")
    public MealPlan addMealplan(@RequestBody MealPlan mealPlan){
        System.out.println("Adding mealplan starting on "+mealPlan.getStart());
        return mealPlanService.addMealPlan(mealPlan);
    }

    @GetMapping("allmeals")
    public Iterable<Meal> allMeals(){
        System.out.println("Finding all mealplans...");
        return mealPlanService.findAllMeals();
    }

    @PostMapping("addmeal/{mealplanid}")
    public Meal addMeal(@RequestBody Meal meal, @PathVariable long mealplanid){
        System.out.println("Adding meal on "+meal.getDate()+" to mealplan with id "+mealplanid);
        return mealPlanService.addMealToMealPlan(meal, mealplanid);
    }

}

package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.MealPlanService;
import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.MealPlan;
import YCpowergroup.mealplanner.domain.Recipe;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
    public MealPlan addMealPlanWithMeals(@RequestBody MealPlan mealPlan){
        System.out.println("Adding mealplan starting on "+mealPlan.getStart());
        return mealPlanService.addMealPlanWithMeals(mealPlan);
    }

    @PostMapping("addmealplanbasic")
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

    @PutMapping("editmeal/{mealid}")
    public Meal editMeal(@RequestBody Meal meal, @PathVariable long mealid) {
        System.out.println("Editing meal with id: " + mealid);
        return mealPlanService.editMeal(meal, mealid);
    }


    @GetMapping("findmealbyid/{mealid}")
    public Optional<Meal> findMealById(@PathVariable long mealid){
        System.out.println("Finding meal with id: "+mealid);
        return mealPlanService.findMealById(mealid);
    }

    @GetMapping("findmealsondate/{mealdate}")
    public List<Meal> findMealsByDate(@PathVariable String mealdate){
        System.out.println("Finding meals on "+mealdate);
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        return mealPlanService.findMealsByDate(LocalDate.parse(mealdate));
    }

    @GetMapping("findmealsbytype/{mealtype}")
    public List<Meal> findMealByMealType(@PathVariable String mealtype){
        System.out.println("Finding "+mealtype+"S");
        return mealPlanService.findMealsByMealType(mealtype);
    }

    @PostMapping("generatemealplan/{servings}")
    public MealPlan generateMealPlan(@RequestBody MealPlan mealPlan, @PathVariable int servings){
        System.out.println("Generating mealplan from "+mealPlan.getStart()+" to "+mealPlan.getEnd());
        return mealPlanService.generateMealPlan(mealPlan, servings);
    }

}

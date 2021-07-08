package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealPlanService {
    @Autowired
    MealPlanRepository mealPlanRepository;

    @Autowired
    MealRepository mealRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public Iterable<MealPlan> findAllMealPlans(){return mealPlanRepository.findAll();}

    public Optional<MealPlan> findMealPlanById(long mealPlanId){
        return mealPlanRepository.findById(mealPlanId);
    }

    public MealPlan addMealPlan(MealPlan mealPlan){
        System.out.println("Adding new mealplan...");
        return mealPlanRepository.save(mealPlan);
    }

    public Iterable<Meal> findAllMeals(){return mealRepository.findAll();}

    public Meal addMealToMealPlan(Meal meal, Long mealPlanId){
        System.out.println("Adding new meal...");
        Meal mealInRepo = mealRepository.save(meal);
        Optional<MealPlan> mealPlan = mealPlanRepository.findById(mealPlanId);
        mealInRepo.setMealPlan(mealPlan.get());
        return mealInRepo;
    }

}

package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.MealPlan;
import YCpowergroup.mealplanner.domain.MealType;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

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

    public Optional<Meal> findMealById(long mealId){
        return mealRepository.findById(mealId);
    }

    public List<Meal> findMealsByDate(LocalDate mealDate){
        return mealRepository.findAllByDate(mealDate);
    }

    public List<Meal> findMealsByMealType(String mealType){
        return mealRepository.findAllByMealType(MealType.valueOf(mealType));
    }

    public MealPlan generateMealPlan(MealPlan mealPlan, int servings){
        Period diff = Period.between(mealPlan.getStart(), mealPlan.getEnd());
        int days = diff.getDays();
        List<Meal> meals = new ArrayList<Meal>();
        String[] mealTypeArr = {"breakfast","lunch","dinner"};
        mealPlan = mealPlanRepository.save(mealPlan);
        for (int i=0;i<=days;i++){
            LocalDate tempDate = mealPlan.getStart().plusDays(i);
            for (String mealType : mealTypeArr){
                Meal meal =generateMeal(tempDate,mealType,servings,mealPlan);
                meals.add(meal);
            }
        }
        return mealPlan;
    }

    public Meal generateMeal(LocalDate date, String mealType, int servings,MealPlan mealPlan){
        Meal meal = new Meal();
        meal.setDate(date);
        meal.setServings(servings);
        meal.setMealPlan(mealPlan);
        List<Recipe> recipesWithType = new ArrayList<Recipe>();
        if (mealType.equals("breakfast")){
            meal.setMealType(MealType.BREAKFAST);
            recipesWithType = recipeRepository.findByBreakfastTrue();
        }else if (mealType.equals("lunch")){
            meal.setMealType(MealType.LUNCH);
            recipesWithType = recipeRepository.findByLunchTrue();
        }else if(mealType.equals("dinner")){
            meal.setMealType(MealType.DINNER);
            recipesWithType = recipeRepository.findByDinnerTrue();
        }
        Random rand = new Random();
        Recipe randomRecipe =  recipesWithType.get(rand.nextInt(recipesWithType.size()));
        meal.setRecipes(Arrays.asList(randomRecipe));
        return mealRepository.save(meal);
    }

}

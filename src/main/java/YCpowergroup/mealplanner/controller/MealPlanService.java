package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.*;
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

    public MealPlan addMealPlanWithMeals(MealPlan mealPlan){
        System.out.println("Adding new mealplan...");
        mealPlanRepository.save(mealPlan);
        generateMeals(mealPlan, 0,"generic");
        return mealPlan;
    }

    public MealPlan generateMealPlan(MealPlan mealPlan, int servings){
        mealPlan = mealPlanRepository.save(mealPlan);
        generateMeals(mealPlan,servings,"random");
        return mealPlan;
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

    public List<Meal> generateMeals(MealPlan mealPlan, int servings, String method){
        List<Meal> meals = new ArrayList<Meal>();
        String[] mealTypeArr = {"breakfast","lunch","dinner"};
        Period diff = Period.between(mealPlan.getStart(), mealPlan.getEnd());
        int days = diff.getDays();
        for (int i=0;i<=days;i++){
            LocalDate tempDate = mealPlan.getStart().plusDays(i);
            for (String mealType : mealTypeArr) {
                Meal meal = new Meal();
                meal.setDate(tempDate);
                meal.setServings(servings);
                meal.setMealPlan(mealPlan);
                if (mealType.equals("breakfast")){
                    meal.setMealType(MealType.BREAKFAST);
                }else if (mealType.equals("lunch")){
                    meal.setMealType(MealType.LUNCH);
                }else if(mealType.equals("dinner")){
                    meal.setMealType(MealType.DINNER);
                }
                if (method == "random") {
                    generateRandomRecipe(meal,mealType);
                }
                mealRepository.save(meal);
                meals.add(meal);
            }
        }
        return meals;
    }

    public Recipe generateRandomRecipe(Meal meal,String mealType){
        List<Recipe> recipesWithType = new ArrayList<Recipe>();
        if (mealType.equals("breakfast")){
            recipesWithType = recipeRepository.findByBreakfastTrue();
        }else if (mealType.equals("lunch")){
            recipesWithType = recipeRepository.findByLunchTrue();
        }else if(mealType.equals("dinner")){
            recipesWithType = recipeRepository.findByDinnerTrue();
        }
        Random rand = new Random();
        Recipe randomRecipe =  recipesWithType.get(rand.nextInt(recipesWithType.size()));
        meal.setRecipes(Arrays.asList(randomRecipe));
        return randomRecipe;
    }

    public Meal editMeal(Meal meal, long id) {
        if(mealRepository.findById(id).isEmpty()){
            System.out.println("Couldn't edit meal with id " + id + " since it could not be found in the database");
        }

        Meal mealTemp = mealRepository.findById(id).get();
//        mealTemp.setMealPlan(meal.getMealPlan());
        mealTemp.setMealType(meal.getMealType());
        mealTemp.setServings(meal.getServings());
        mealTemp.setDate(meal.getDate());
        mealTemp.setRecipes(meal.getRecipes());
        System.out.println("Meal " + id + " edited");
        return mealRepository.save(mealTemp);

    }

}

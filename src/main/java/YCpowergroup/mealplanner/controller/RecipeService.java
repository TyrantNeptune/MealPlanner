package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
import YCpowergroup.mealplanner.domain.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	IngredientRepository ingredientRepository;

	@Autowired
	RecipeIngredientRepository recipeIngredientRepository;

	public Iterable<Recipe> findAllRecipes() {
		return recipeRepository.findAll();
	}

	public Iterable<Recipe> findRecipesByName(String recipeName) {
		System.out.println("In findRecipeByName");
		return recipeRepository.findByNameLike("%"+recipeName+"%");
	}

	public Iterable<Recipe> findDistinctRecipesByNameIn(List<String> recipeNames) {
		return recipeRepository.findDistinctRecipesByNameIn(recipeNames);
	}

	public Iterable<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public Ingredient findIngredientById(Long ingredientId) {
		return ingredientRepository.findById(ingredientId).get();
	}

	public List<Recipe> findRecipesByIngredient(String ingredientName) {
		List<Ingredient> ingredients = ingredientRepository.findAllByNameContaining(ingredientName);
		List<Long> recipeIds = new ArrayList<>();
		for (Ingredient ingredient : ingredients) {
			List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByIngredient(ingredient);
			for (RecipeIngredient recipeIngredient : recipeIngredients) {
				recipeIds.add(recipeIngredient.getRecipe().getId());
			}
		}
		System.out.println("Found " + ingredients.size() + " ingredients with name: " + ingredientName);

		return recipeRepository.findByIdIn(recipeIds);
	}

	public Recipe addRecipe(Recipe recipe) {
		System.out.println("Adding new recipe...");
		return recipeRepository.save(recipe);
	}

	public Optional<Recipe> findRecipeById(long recipeId) {
		return recipeRepository.findById(recipeId);
	}

	public Ingredient addIngredientToDb(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
		System.out.println("in addRecipeIngredient Service");
		recipeIngredientRepository.save(recipeIngredient);
	}

	public Optional<RecipeIngredient> findRecipeIngredientById(long id) {
		return recipeIngredientRepository.findById(id);
	}

	public void editRecipeIngredient(RecipeIngredient recipeIngredient, long id){
		if(recipeIngredientRepository.findById(id).isEmpty()){
			System.out.println("Couldn't edit recipe ingredient with id " + id + " since it could not be found in the database");
			return;
		}

		RecipeIngredient recipeIngredientTemp   = recipeIngredientRepository.findById(id).get();
		recipeIngredientTemp.setAmount(recipeIngredient.getAmount());
		recipeIngredientTemp.setCategory(recipeIngredient.getCategory());
		recipeIngredientTemp.setIngredient(recipeIngredient.getIngredient());
		recipeIngredientTemp.setRecipe(recipeIngredient.getRecipe());
		recipeIngredientTemp.setUnit(recipeIngredient.getUnit());
		recipeIngredientRepository.save(recipeIngredientTemp);
		System.out.println("Recipe ingredient " + id + " edited.");
	}


	public void editRecipe(Recipe recipe, long id){
		if(recipeRepository.findById(id).isEmpty()){
			System.out.println("Couldn't edit recipe with id " + id + " since it could not be found in the database");
			return;
		}
		Recipe recipeTemp   = recipeRepository.findById(id).get();
		recipeTemp.setCaloriesPerServing(recipe.getCaloriesPerServing());
		recipeTemp.setProteinPerServing(recipe.getProteinPerServing());
		recipeTemp.setCarbsPerServing((recipe.getCarbsPerServing()));
		recipeTemp.setFatsPerServing(recipe.getFatsPerServing());
		recipeTemp.setNetCarbsPerServing(recipe.getNetCarbsPerServing());
		recipeTemp.setName((recipe.getName()));
		recipeTemp.setInstructions(recipe.getInstructions());
		recipeTemp.setDescription(recipe.getDescription());
		recipeTemp.setServings(recipe.getServings());
		recipeTemp.setRecipeIngredients(recipe.getRecipeIngredients());
		recipeTemp.setPicture(recipe.getPicture());
		recipeTemp.setBreakfast(recipe.isBreakfast());
		recipeTemp.setLunch(recipe.isLunch());
		recipeTemp.setDinner(recipe.isDinner());
		recipeRepository.save(recipeTemp);
		System.out.println("Recipe " + id + " edited.");
	}


	public Iterable<Ingredient> findIngredientsByName(String ingredientName) {
		List<Ingredient> ingredients = ingredientRepository.findAllByNameContaining(ingredientName);
		System.out.println("Found " + ingredients.size() + " ingredients with name: " + ingredientName);
		return ingredientRepository.findAllByNameContaining(ingredientName);
	}

	public List<Recipe> findRecipesByMealType(String mealType) {
		List<Recipe> recipes = new ArrayList<>();
		if (mealType.equals("breakfast")) {
			List<Recipe> recipeList = recipeRepository.findByBreakfastTrue();
			recipes.addAll(recipeList);
		}
		if (mealType.equals("lunch")) {
			List<Recipe> recipeList = recipeRepository.findByLunchTrue();
			recipes.addAll(recipeList);
		}
		if (mealType.equals("dinner")) {
			List<Recipe> recipeList = recipeRepository.findByDinnerTrue();
			recipes.addAll(recipeList);
		}
		return recipes;
	}

	public void addMultipleRecipes(Iterable<Recipe> recipes) {
		recipeRepository.saveAll(recipes);
	}

	/*public Optional<RecipeIngredient> changeRecipeIngredient(long recipeIngredientId){
		RecipeIngredient recipeIngredient = recipeIngredientRepository.findById(recipeIngredientId).get();

	}

	 */

	public void deleteRecipeIngredient(long recipeIngredientId){
		recipeIngredientRepository.deleteById(recipeIngredientId);
	}

	public double calculateNutritionValuesPerServingGr(double amount, double valuePer100) {
		double valuePer1Gr = valuePer100 / 100.0;
		double totalGrValueInRecipe = valuePer1Gr * amount;

		return totalGrValueInRecipe;
	}

	public double calculateNutritionValuesPerServingMl(double amount, double valuePer100, double density) {
		double valuePer100Ml = valuePer100 * density;
		double valuePer1Ml = valuePer100Ml/ 100.0;
		double totalMlValueInRecipe = valuePer1Ml * amount;

		return totalMlValueInRecipe;
	}

	public double calculateNutritionValuesPerServingTbsp(double amount, double valuePer100, double density) {
		double valuePer100Ml = valuePer100 * density;
		double valuePer1Ml = valuePer100Ml/ 100.0;
		double valuePerTbsp = valuePer1Ml * 15.0;
		double totalTbspValueInRecipe = valuePerTbsp * amount;

		return totalTbspValueInRecipe;
	}

	public double calculateNutritionValuesPerServingTsp(double amount, double valuePer100, double density) {
		double valuePer100Ml = valuePer100 * density;
		double valuePer1Ml = valuePer100Ml/ 100.0;
		double valuePerTsp = valuePer1Ml * 5.0;
		double totalTspValueInRecipe = valuePerTsp * amount;

		return totalTspValueInRecipe;
	}

	public double calculateNutritionValuesPerServingCup(double amount, double valuePer100, double density) {
		double valuePer100Ml = valuePer100 * density;
		double valuePer1Ml = valuePer100Ml/ 100.0;
		double valuePerCup = valuePer1Ml * 236.588;
		double totalCupValueInRecipe = valuePerCup * amount;

		return totalCupValueInRecipe;
	}

	public Recipe updateNutritionValues(Long recipeId) {
		Recipe recipe = recipeRepository.findById(recipeId).get();
		List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
		double totalCarbsInRecipe = 0.0;
		double totalNetCarbsInRecipe = 0.0;
		double totalFatsInRecipe = 0.0;
		double totalCaloriesInRecipe = 0.0;
		double totalProteinInRecipe = 0.0;

		for (RecipeIngredient recipeIngredient : recipeIngredients) {
			if (recipeIngredient.getUnit() == Unit.GR) {
				totalCarbsInRecipe += calculateNutritionValuesPerServingGr(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCarbs());
				totalNetCarbsInRecipe += calculateNutritionValuesPerServingGr(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getNetCarbs());
				totalFatsInRecipe += calculateNutritionValuesPerServingGr(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getFats());
				totalCaloriesInRecipe += calculateNutritionValuesPerServingGr(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCalories());
				totalProteinInRecipe += calculateNutritionValuesPerServingGr(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getProtein());
			}
			else if (recipeIngredient.getUnit() == Unit.ML) {
				totalCarbsInRecipe += calculateNutritionValuesPerServingMl(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCarbs(), recipeIngredient.getIngredient().getDensity());
				totalNetCarbsInRecipe += calculateNutritionValuesPerServingMl(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getNetCarbs(), recipeIngredient.getIngredient().getDensity());
				totalFatsInRecipe += calculateNutritionValuesPerServingMl(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getFats(), recipeIngredient.getIngredient().getDensity());
				totalCaloriesInRecipe += calculateNutritionValuesPerServingMl(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCalories(), recipeIngredient.getIngredient().getDensity());
				totalProteinInRecipe += calculateNutritionValuesPerServingMl(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getProtein(), recipeIngredient.getIngredient().getDensity());
			}
			else if (recipeIngredient.getUnit() == Unit.TBSP) {
				totalCarbsInRecipe += calculateNutritionValuesPerServingTbsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCarbs(), recipeIngredient.getIngredient().getDensity());
				totalNetCarbsInRecipe += calculateNutritionValuesPerServingTbsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getNetCarbs(), recipeIngredient.getIngredient().getDensity());
				totalFatsInRecipe += calculateNutritionValuesPerServingTbsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getFats(), recipeIngredient.getIngredient().getDensity());
				totalCaloriesInRecipe += calculateNutritionValuesPerServingTbsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCalories(), recipeIngredient.getIngredient().getDensity());
				totalProteinInRecipe += calculateNutritionValuesPerServingTbsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getProtein(), recipeIngredient.getIngredient().getDensity());
			}

			else if (recipeIngredient.getUnit() == Unit.TSP) {
				totalCarbsInRecipe += calculateNutritionValuesPerServingTsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCarbs(), recipeIngredient.getIngredient().getDensity());
				totalNetCarbsInRecipe += calculateNutritionValuesPerServingTsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getNetCarbs(), recipeIngredient.getIngredient().getDensity());
				totalFatsInRecipe += calculateNutritionValuesPerServingTsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getFats(), recipeIngredient.getIngredient().getDensity());
				totalCaloriesInRecipe += calculateNutritionValuesPerServingTsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCalories(), recipeIngredient.getIngredient().getDensity());
				totalProteinInRecipe += calculateNutritionValuesPerServingTsp(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getProtein(), recipeIngredient.getIngredient().getDensity());
			}

			else if (recipeIngredient.getUnit() == Unit.CUP) {
				totalCarbsInRecipe += calculateNutritionValuesPerServingCup(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCarbs(), recipeIngredient.getIngredient().getDensity());
				totalNetCarbsInRecipe += calculateNutritionValuesPerServingCup(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getNetCarbs(), recipeIngredient.getIngredient().getDensity());
				totalFatsInRecipe += calculateNutritionValuesPerServingCup(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getFats(), recipeIngredient.getIngredient().getDensity());
				totalCaloriesInRecipe += calculateNutritionValuesPerServingCup(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getCalories(), recipeIngredient.getIngredient().getDensity());
				totalProteinInRecipe += calculateNutritionValuesPerServingCup(recipeIngredient.getAmount(), recipeIngredient.getIngredient().getProtein(), recipeIngredient.getIngredient().getDensity());
			}
		}

		double carbsPerServing = totalCarbsInRecipe / recipe.getServings();
		double netCarbsPerServing = totalNetCarbsInRecipe / recipe.getServings();
		double fatsPerServing = totalFatsInRecipe / recipe.getServings();
		double caloriesPerServing = totalCaloriesInRecipe / recipe.getServings();
		double proteinPerServing = totalProteinInRecipe / recipe.getServings();

		recipe.setCarbsPerServing(carbsPerServing);
		recipe.setNetCarbsPerServing(netCarbsPerServing);
		recipe.setFatsPerServing(fatsPerServing);
		recipe.setCaloriesPerServing(caloriesPerServing);
		recipe.setProteinPerServing(proteinPerServing);

		System.out.println("Saving recipe: " + recipe.getName());

		return recipeRepository.save(recipe);
	}
}
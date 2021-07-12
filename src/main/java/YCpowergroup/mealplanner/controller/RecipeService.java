package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
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
		return recipeRepository.findByNameLike("%"+recipename+"%");
	}

	public Iterable<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public List<Recipe> findRecipesByIngredient(String ingredientName) {
		List<Ingredient> ingredients = ingredientRepository.findAllByNameContaining(ingredientName);
		List<Long> recipeIngredientIds = new ArrayList<>();
		for (Ingredient ingredient : ingredients) {
			List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByIngredient(ingredient);
			for (RecipeIngredient recipeIngredient : recipeIngredients) {
				recipeIngredientIds.add(recipeIngredient.getId());
			}
		}
		System.out.println("Found " + ingredients.size() + " ingredients with name: " + ingredientName);

		return recipeRepository.findByRecipeIngredientsIdIn(recipeIngredientIds);
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
}
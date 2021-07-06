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

	public Iterable<Recipe> findRecipesByName(String recipename) {
		System.out.println("In findRecipeByName");
		return recipeRepository.findAllByNameContaining(recipename);
	}

	public Iterable<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public Iterable<Recipe> findRecipeByIngredient(String ingredientname) {
		Ingredient i = ingredientRepository.findIngredientByName(ingredientname);
		List<RecipeIngredient> recipeIngredients = recipeIngredientRepository.findByIngredient(i);
		List<Long> recipeIngredientIds = new ArrayList<>();
		for (RecipeIngredient recipeIngredient : recipeIngredients) {
			recipeIngredientIds.add(recipeIngredient.getId());
		}
		System.out.println("in findRecipeByIngredient: "+ ingredientname);
		return recipeRepository.findByRecipeIngredientsIdIn(recipeIngredientIds);
	}

	public Recipe addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	public Optional<Recipe> findRecipeById(long recipeid) {
		return recipeRepository.findById(recipeid);
	}

	public Ingredient addIngredientToDb(Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	public void addRecipeIngredient(RecipeIngredient recipeIngredient) {
		recipeIngredientRepository.save(recipeIngredient);
	}
}
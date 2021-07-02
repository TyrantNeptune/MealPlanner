package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	IngredientRepository ingredientRepository;

	public Iterable<Recipe> findAllRecipes() {
		return recipeRepository.findAll();
	}

	public void findRecipeByName(String value) {
		List<Recipe> recipes = recipeRepository.findAllByNameContaining(value);
		System.out.println(recipes.size());
	}

	public Iterable<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public void addIngredientToRecipe(long recipeId, Ingredient ingredient) {
		Recipe recipe = recipeRepository.findById(recipeId).get();
		Ingredient i = ingredientRepository.save(ingredient);
		recipe.setIngredient(i);
		recipeRepository.save(recipe);

		System.out.println("We have arrived in the service "+recipeId+"<,.>"+ingredient.getName());
	}


}
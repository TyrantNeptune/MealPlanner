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

	public Iterable<Recipe> findRecipesByName(String recipename) {
		System.out.println("In findRecipeByName");
		return recipeRepository.findAllByNameContaining(recipename);
	}

	public Iterable<Ingredient> findAllIngredients() {
		return ingredientRepository.findAll();
	}

	public void addIngredientToRecipe(long recipeId, Ingredient ingredient) {
		Recipe recipe = recipeRepository.findById(recipeId).get();
		Ingredient i = ingredientRepository.save(ingredient);
		recipe.setIngredient(i);
		recipeRepository.save(recipe);

		System.out.println("We have arrived in the service "+recipeId+"<..>"+ingredient.getName());
	}

	public List<Recipe> findRecipeByIngredient(String ingredientname) {
		Ingredient i = ingredientRepository.findIngredientByName(ingredientname);
		System.out.println("in findRecipeByIngredient: "+ ingredientname);

		return recipeRepository.findAllByIngredient(i);
	}
}
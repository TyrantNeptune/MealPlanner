package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeEndpoint {
	@Autowired
	RecipeService recipeService;

	@GetMapping("all-recipes")
	public Iterable<Recipe> allRecipes(){
		System.out.println("In all recipes");
		return recipeService.findAllRecipes();
	}

	@GetMapping("findrecipebyname")  // straks een naam
	public String findRecipeByName(){
		String potato = "potato";
		recipeService.findRecipeByName(potato);
		return "found";
	}

	@PostMapping("addingredient/{recipeid}")
	public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable long recipeid) {
		System.out.println("it works: "+ingredient.getName());
		recipeService.addIngredientToRecipe(recipeid,ingredient);
	}

	@GetMapping("findrecipebyingredient/{ingredientname}")
	public Iterable<Recipe> findRecipeByIngredient(@PathVariable String ingredientname) {
		System.out.println("find recipe with: "+ingredientname);
		return recipeService.findRecipeByIngredient(ingredientname);
	}


	// ophalen van EN recept EN ingredient
	// D -- nieuw recept met meteen al een nieuw ingredient
	// ---------  nieuw ingredient toevoegen aan bestaand recept
	// J -- bestaand ingredient koppelen aan bestaand recept
	// R -- recepten vinden met naam van ingredient
	// recept lijst van ingredienten geven OneTOMany
	// Dependency toevoegen (DevTools)







}
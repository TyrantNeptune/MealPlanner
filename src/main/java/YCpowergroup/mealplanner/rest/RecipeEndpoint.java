package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class RecipeEndpoint {
	@Autowired
	RecipeService recipeService;

	@GetMapping("allrecipes")
	public Iterable<Recipe> allRecipes(){
		System.out.println("In all recipes");
		return recipeService.findAllRecipes();
	}

	@GetMapping("findrecipesbyname/{recipename}")  // straks een naam
	public Iterable<Recipe> findRecipesByName(@PathVariable String recipename){
		System.out.println("finding recipes: "+ recipename);
		return recipeService.findRecipesByName(recipename);
	}

	@GetMapping("findrecipebyid/{recipeid}")
	public Optional<Recipe> findRecipeById(@PathVariable long recipeid) {
		System.out.println("finding recipe with id: " + recipeid);
		return recipeService.findRecipeById(recipeid);
	}

	@PostMapping("addingredient/{recipeid}")
	public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable long recipeid) {
		System.out.println("it works: "+ingredient.getName());
		recipeService.addIngredientToRecipe(recipeid,ingredient);
	}

	@GetMapping("findrecipesbyingredient/{ingredientname}")
	public Iterable<Recipe> findRecipeByIngredient(@PathVariable String ingredientname) {
		System.out.println("find recipe with: "+ingredientname);
		return recipeService.findRecipeByIngredient(ingredientname);
	}


	@PostMapping("addrecipewithingredient")
	public void addRecipeWithNewIngredient(@RequestBody Ingredient ingredient, @RequestBody Recipe recipe){
		System.out.println("ingredient works: "+ingredient.getName());
		System.out.println("recipe works: "+recipe.getName());
	}

	@PostMapping("addrecipe")
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		System.out.println("adding recipe " + recipe.getName() + "to database");
		return recipeService.addRecipe(recipe);

	}


	// ophalen van EN recept EN ingredient
	// D -- nieuw recept met meteen al een nieuw ingredient
	// ---------  nieuw ingredient toevoegen aan bestaand recept
	// J -- bestaand ingredient koppelen aan bestaand recept
	// R -- recepten vinden met naam van ingredient
	// recept lijst van ingredienten geven OneTOMany
	// Dependency toevoegen (DevTools)







}
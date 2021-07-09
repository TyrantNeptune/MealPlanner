package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.event.ListDataEvent;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class RecipeEndpoint {
	@Autowired
	RecipeService recipeService;

	@GetMapping("allrecipes")
	public Iterable<Recipe> allRecipes(){
		System.out.println("Finding all recipes...");
		return recipeService.findAllRecipes();
	}

	@GetMapping("allingredients")
	public Iterable<Ingredient> allIngredients() {
		System.out.println("Finding all ingredients...");
		return recipeService.findAllIngredients();
	}

	@GetMapping("findrecipesbyname/{recipename}")  // straks een naam
	public Iterable<Recipe> findRecipesByName(@PathVariable String recipename){
		System.out.println("Finding recipes with name: "+ recipename);
		return recipeService.findRecipesByName(recipename);
	}

	@GetMapping("findrecipebyid/{recipeid}")
	public Optional<Recipe> findRecipeById(@PathVariable long recipeid) {
		System.out.println("Finding recipe with id: " + recipeid);
		return recipeService.findRecipeById(recipeid);
	}

//	@PostMapping("addingredient/{recipeid}")
//	public void addIngredientToRecipe(@RequestBody Ingredient ingredient, @PathVariable long recipeid) {
//		System.out.println("it works: "+ingredient.getName());
//		recipeService.addIngredientToRecipe(recipeid,ingredient);
//	}

	@GetMapping("findrecipesbyingredient/{ingredientname}")
	public List<Recipe> findRecipeByIngredient(@PathVariable String ingredientname) {
		System.out.println("Finding recipe with ingredient: "+ingredientname);
		List<Recipe> recipes = recipeService.findRecipesByIngredient(ingredientname);
		if (recipes.size() == 0) {
			System.out.println("No recipes found!");
		} else {
			System.out.println(recipes.size() + " recipes found!");
		}
		return recipes;
	}

//	@PostMapping("addrecipewithingredient")
//	public void addRecipeWithNewIngredient(@RequestBody Ingredient ingredient, @RequestBody Recipe recipe){
//		System.out.println("ingredient works: "+ingredient.getName());
//		System.out.println("recipe works: "+recipe.getName());
//	}

	@PostMapping("addrecipe")
	public Recipe addRecipe(@RequestBody Recipe recipe) {
		System.out.println("Adding recipe " + recipe.getName() + "to database");
		return recipeService.addRecipe(recipe);

	}

	@PostMapping("addingredienttodb")
	public Ingredient addIngredientToDb(@RequestBody Ingredient ingredient) {
		System.out.println("Adding ingredient " + ingredient.getName() + " to datbase");
		return recipeService.addIngredientToDb(ingredient);
	}

	@GetMapping("findingredientsbyname/{ingredientname}")
	public Iterable<Ingredient> findIngredientsByName(@PathVariable String ingredientname) {
		System.out.println("Finding ingredient: " + ingredientname);
		return recipeService.findIngredientsByName(ingredientname);
	}

	// ophalen van EN recept EN ingredient
	// D -- nieuw recept met meteen al een nieuw ingredient
	// ---------  nieuw ingredient toevoegen aan bestaand recept
	// J -- bestaand ingredient koppelen aan bestaand recept
	// R -- recepten vinden met naam van ingredient
	// recept lijst van ingredienten geven OneTOMany
	// Dependency toevoegen (DevTools)







}
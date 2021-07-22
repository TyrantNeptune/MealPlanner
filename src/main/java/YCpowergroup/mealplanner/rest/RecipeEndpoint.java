package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("addrecipeingredient")
	public void addIngredientToRecipe(@RequestBody RecipeIngredient recipeIngredient) {
		System.out.println("it works");
		recipeService.addRecipeIngredient(recipeIngredient);
	}

	@GetMapping("getrecipeingredient/{id}")
	public Optional<RecipeIngredient> getRecipeIngredient(@PathVariable long id) {
		return recipeService.findRecipeIngredientById(id);
	}

	@GetMapping("findrecipesbyingredient/{ingredientname}")
	public List<Recipe> findRecipesByIngredient(@PathVariable String ingredientname) {
		System.out.println("Finding recipe with ingredient: "+ingredientname);
		List<Recipe> recipes = recipeService.findRecipesByIngredient(ingredientname);
		if (recipes.size() == 0) {
			System.out.println("No recipes found!");
		} else {
			System.out.println(recipes.size() + " recipes found!");
		}
		return recipes;
	}

	@GetMapping("findrecipesbymealtype/{mealtype}")
	public List<Recipe> findRecipesByMealType(@PathVariable String mealtype) {
		System.out.println("Finding recipes for: " + mealtype);
		List<Recipe> recipes = recipeService.findRecipesByMealType(mealtype);
		if (recipes.size() == 0) {
			System.out.println("No recipes found");
		} else {
			System.out.println(recipes.size() + " recipes found!");
		}
		return recipes;
	}

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

	@GetMapping("findingredientbyid/{ingredientid}")
	public Ingredient findIngredientById(@PathVariable Long ingredientid) {
		System.out.println("Finding ingredient with id: " + ingredientid);
		return recipeService.findIngredientById(ingredientid);
	}

	@PostMapping("addmultiplerecipes")
	public void addMultipleRecipes(@RequestBody Iterable<Recipe> recipes) {
		recipeService.addMultipleRecipes(recipes);
	}

	@PostMapping("finishrecipe/{recipeid}")
	public Recipe finishRecipe(@PathVariable long recipeid) {
		return recipeService.updateNutritionValues(recipeid);
	}

	//@PutMapping("changerecipeingredient/{recipeingredientid}")
	//public Optional<RecipeIngredient> changeRecipeIngredient(@PathVariable long recipeingredientid){return recipeService.changeRecipeInGredient(recipeingredientid)}

	@DeleteMapping("deleterecipeingredient/{recipeingredientid}")
	public void deleteRecipeIngredient(@PathVariable long recipeingredientid){
		System.out.println("Deleting RecipeIngredient with id " + recipeingredientid);
		recipeService.deleteRecipeIngredient(recipeingredientid);}


	@PutMapping ("editrecipeingredient/{id}")
	public void editRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient, @PathVariable long id){
		recipeService.editRecipeIngredient(recipeIngredient, id);
	}

	@PutMapping ("editrecipe/{id}")
	public void editRecipeIngredient(@RequestBody Recipe recipe, @PathVariable long id){
		recipeService.editRecipe(recipe, id);
	}
}

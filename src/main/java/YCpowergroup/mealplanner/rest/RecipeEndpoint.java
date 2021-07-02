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
	
	@GetMapping("allerecepten")
	public Iterable<Recipe> allerecepten(){
		System.out.println("ik ben in alle recepten");
		return recipeService.geefAlleRecepten();
	}
	
	@GetMapping("vindreceptmetnaam")  // straks een naam
	public String vindreceptbijnaam(){
		String aardappel = "aardappel";
		recipeService.zoekBijNaam(aardappel);
		return "gevonden";
	}
	
	@PostMapping("voegingredienttoe/{receptid}")
	public void voegingredienttoe(@RequestBody Ingredient ingredient, @PathVariable long receptid) {
		System.out.println("hij doet het"+ingredient.getNaam());
		recipeService.voegIngredientToeAanRecept(receptid,ingredient);
	}
	// ophalen van EN recept EN ingredient
	// nieuw recept met meteen al een nieuw ingredient
	// ---------  nieuw ingredient toevoegen aan bestaand recept
	// bestaand ingredient koppelen aan bestaand recept
	// recepten vinden met naam van ingredient
	// recept lijst van ingredienten geven OneTOMany
	// Dependency toevoegen (DevTools)
	
	
	
	
	
	
	
}

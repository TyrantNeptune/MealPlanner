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
	
	public Iterable<Recipe> geefAlleRecepten() {
		return recipeRepository.findAll();
	}

	public void zoekBijNaam(String zoekterm) {
		List<Recipe> recepten = recipeRepository.findAllByNaamContaining(zoekterm);
		System.out.println(recepten.size());
	}
	
	public Iterable<Ingredient> geefAlleIngredienten() {
		return ingredientRepository.findAll();
	}
	
	public void voegIngredientToeAanRecept(long receptid, Ingredient ingredient) {
		Recipe recept = recipeRepository.findById(receptid).get();
		Ingredient i = ingredientRepository.save(ingredient);
		recept.setIngredient(i);
		recipeRepository.save(recept);
		
		System.out.println("we zijn aangekomen in de service"+receptid+"<,.>"+ingredient.getNaam());
	}
	
	
}

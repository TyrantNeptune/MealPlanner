package YCpowergroup.mealplanner.domain.domeinoefenen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeFService {
	@Autowired
	RecipeFRepository recipeFRepository;
	
	@Autowired
	IngredientFRepository ingredientFRepository;
	
	public Iterable<RecipeF> geefAlleRecepten() {
		return recipeFRepository.findAll();
	}

	public void zoekBijNaam(String zoekterm) {
		List<RecipeF> recepten = recipeFRepository.findAllByNaamContaining(zoekterm);
		System.out.println(recepten.size());
	}
	
	public Iterable<IngredientF> geefAlleIngredienten() {
		return ingredientFRepository.findAll();
	}
	
	public void voegIngredientToeAanRecept(long receptid, IngredientF ingredient) {
		RecipeF recept = recipeFRepository.findById(receptid).get();
		IngredientF i = ingredientFRepository.save(ingredient);
		recept.setIngredient(i);
		recipeFRepository.save(recept);
		
		System.out.println("we zijn aangekomen in de service"+receptid+"<,.>"+ingredient.getNaam());
	}
	
	
}

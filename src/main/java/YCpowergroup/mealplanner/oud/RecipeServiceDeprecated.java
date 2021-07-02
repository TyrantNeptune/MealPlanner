package YCpowergroup.mealplanner.oud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceDeprecated {

    @Autowired
    RecipeRepositoryDeprecated recipeRepository;

    public Iterable<RecipeDeprecated> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Iterable<RecipeDeprecated> findRecipeByName(String zoekterm) {
        return recipeRepository.findAllByNameContaining(zoekterm);
    }

    public RecipeDeprecated saveRecipe(RecipeDeprecated recipeDeprecated) {
        System.out.println("binnen" + recipeDeprecated.getName());
        return recipeRepository.save(recipeDeprecated);
    }
}

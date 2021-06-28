package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public Iterable<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Iterable<Recipe> findRecipeByName(String zoekterm) {
        System.out.println("hoi");
        return recipeRepository.findAllByNameContaining(zoekterm);
    }
}

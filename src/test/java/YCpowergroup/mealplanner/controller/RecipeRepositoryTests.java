package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RecipeRepositoryTests {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void checkIfRepositorySavesQuestion() {
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        Recipe savedRecipe = recipeRepository.save(recipe);
        recipe.setName("Is dit een andere test?");

        assertNotNull(savedRecipe);
        assertEquals(recipe, savedRecipe);
    }

    @Test
    public void checkIfQuestionExistsInDatabase() {
        Recipe recipe = new Recipe();
        recipe.setName("Test");
        recipeRepository.save(recipe);
        Recipe foundRecipe = recipeRepository.findById(recipe.getId()).get();

        assertEquals(recipe.getId(), foundRecipe.getId());
        assertEquals(recipe.getName(), foundRecipe.getName());
    }
}

package YCpowergroup.mealplanner.controller;


import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RecipeServiceTests {
    @Configuration
    static class testConfig {
        @Bean
        public RecipeService recipeService() {
            return new RecipeService();
        }
    }

    @Autowired
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

    @MockBean
    private IngredientRepository ingredientRepository;

    @MockBean
    private RecipeIngredientRepository recipeIngredientRepository;

    @BeforeEach
    public void setUp() {
        Recipe recipe1 = new Recipe();
        recipe1.setName("Test");
        recipe1.setId(0);
        Recipe recipe2 = new Recipe();
        recipe2.setId(3);

        List<Recipe> questionList = new ArrayList<Recipe>();
        questionList.add(recipe1);
        questionList.add(recipe2);

        when(recipeRepository.findById(recipe1.getId()))
                .thenReturn(java.util.Optional.of(recipe1));
        when(recipeRepository.save(recipe1))
                .thenReturn(recipe1);
        when(recipeRepository.findAll())
                .thenReturn(questionList);
    }

    @Test
    public void checkThatFindByIdWorks() {
        long id = 0;
        Recipe recipe = recipeService.findRecipeById(id).get();
        assertEquals("Test", recipe.getName());
    }

    @Test
    public void checkThatFindAllWorks() {
        Iterable<Recipe> recipes = recipeService.findAllRecipes();
        int expectedNumberOfQuestions = 2;
        int count = 0;
        for (Recipe recipe : recipes) {
            count++;
        }
        assertEquals(expectedNumberOfQuestions, count);

        verify(recipeRepository).findAll();
        verifyNoMoreInteractions(recipeRepository);
    }
}

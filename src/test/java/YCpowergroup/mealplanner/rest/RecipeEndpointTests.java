package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeRepository;
import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipeEndpointTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp() {
        Recipe go = new Recipe();
        go.setName("test");
        Recipe[] recipeArray = {
                new Recipe(),
                go
        };
        recipeArray[1].setId((long)1);
        Iterable<Recipe> recipes = Arrays.asList(recipeArray);

        when(recipeService.findRecipeById(recipeArray[0].getId())).thenReturn(ofNullable(recipeArray[0]));
        when(recipeService.findRecipeById(recipeArray[1].getId())).thenReturn(ofNullable(recipeArray[1]));
        when(recipeService.findAllRecipes()).thenReturn(recipes);
    }

    @Test
    public void getRecipesFromEndpointWithMockedService() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/allrecipes", String.class);
        System.out.println(entity);

        assertEquals(200, entity.getStatusCodeValue());
        assertEquals("[{\"id\":0,\"name\":\"\",\"servings\":0,\"description\":null,\"instructions\":null,\"picture\":null,\"breakfast\":false,\"lunch\":false,\"dinner\":false,\"recipeIngredients\":null,\"carbsPerServing\":0.0,\"netCarbsPerServing\":0.0,\"fatsPerServing\":0.0,\"caloriesPerServing\":0.0,\"proteinPerServing\":0.0},{\"id\":1,\"name\":\"test\",\"servings\":0,\"description\":null,\"instructions\":null,\"picture\":null,\"breakfast\":false,\"lunch\":false,\"dinner\":false,\"recipeIngredients\":null,\"carbsPerServing\":0.0,\"netCarbsPerServing\":0.0,\"fatsPerServing\":0.0,\"caloriesPerServing\":0.0,\"proteinPerServing\":0.0}]",
                entity.getBody());

        verify(recipeService).findAllRecipes();
        verify(recipeService, never()).findRecipeById(anyLong());

        verifyNoInteractions(recipeRepository);
    }
}

package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.RecipeRepository;
import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.MealType;
import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecpieEndpointTests {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private RecipeService recipeService;

    @MockBean
    private RecipeRepository recipeRepository;

    @BeforeEach
    public void init() {
        Recipe go = new Recipe();
        go.setName("test");
        Recipe[] recipeArray = {
                new Recipe(),
                go
        };
        recipeArray[1].setId((long)1);
        Iterable<Recipe> recipes = Arrays.asList(recipeArray);

        when(recipeService.findRecipeById(recipeArray[0].getId())).thenReturn(java.util.Optional.ofNullable(recipeArray[0]));
        when(recipeService.findRecipeById(recipeArray[1].getId())).thenReturn(java.util.Optional.ofNullable(recipeArray[1]));
        when(recipeService.findAllRecipes()).thenReturn(recipes);
    }

    @Test
    public void getQuestionsFromEndpointWithMockedService() {
        ResponseEntity<String> entity = restTemplate.getForEntity("/allrecipes", String.class);
        System.out.println(entity);

        assertEquals(200, entity.getStatusCodeValue());
        assertEquals("[{\"id\":0,\"name\":null,\"servings\":0,\"description\":null,\"instructions\":null,\"picture\":null,\"breakfast\":false,\"lunch\":false,\"dinner\":false,\"recipeIngredients\":null},{\"id\":1,\"name\":\"test\",\"servings\":0,\"description\":null,\"instructions\":null,\"picture\":null,\"breakfast\":false,\"lunch\":false,\"dinner\":false,\"recipeIngredients\":null}]",
                entity.getBody());

        verify(recipeService).findAllRecipes();
        verify(recipeService, never()).findRecipeById(anyLong());

        verifyNoInteractions(recipeRepository);
    }
}

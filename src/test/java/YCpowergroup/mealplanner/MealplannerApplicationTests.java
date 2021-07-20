package YCpowergroup.mealplanner;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class MealplannerApplicationTests {

	private static Recipe testRecipe;

	@BeforeAll
	static void init() {
		testRecipe = new Recipe();
	}

	@Test
	void recipeNameTest() {
		testRecipe.setName("testing");
		assertEquals("testing", testRecipe.getName());
	}

	@Test
	void recipeServingsTest() {
		testRecipe.setServings(4);
		assertEquals(4, testRecipe.getServings());
	}
}

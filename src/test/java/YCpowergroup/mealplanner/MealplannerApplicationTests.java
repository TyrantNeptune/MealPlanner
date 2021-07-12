package YCpowergroup.mealplanner;

import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class MealplannerApplicationTests {

	private static Recipe testRecipe;

	@BeforeAll
	static void init() {
		testRecipe = new Recipe();
		testRecipe.setName("testing");
		testRecipe.setServings(4);
	}

	@Test
	void recipeNameTest() {
		assertEquals("testing", testRecipe.getName());
	}

	@Test
	void recipeServingsTest() {
		assertEquals(4, testRecipe.getServings());
	}
}

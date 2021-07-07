package YCpowergroup.mealplanner;

import YCpowergroup.mealplanner.domain.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		assertEquals(0, testRecipe.getServings());
	}
}

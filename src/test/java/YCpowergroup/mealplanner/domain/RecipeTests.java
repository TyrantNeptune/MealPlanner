package YCpowergroup.mealplanner.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeTests {
    @Test
    public void checkThatEmptyConstructorWorks() {
        Recipe recipe = new Recipe();
        assertEquals(0, recipe.getId());
        assertEquals("", recipe.getName());
        assertEquals(0, recipe.getServings());
    }

    @Test
    public void checkThatSettersWork() {
        Recipe recipe = new Recipe();
        recipe.setId(5);
        recipe.setServings(11);
        recipe.setName("test string");
        assertEquals(5, recipe.getId());
        assertEquals("test string", recipe.getName());
        assertEquals(11, recipe.getServings());
    }
}

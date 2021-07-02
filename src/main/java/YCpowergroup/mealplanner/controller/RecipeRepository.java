package YCpowergroup.mealplanner.controller;

import java.util.List;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends CrudRepository<Recipe,Long> {
	List<Recipe> findAllByNameContaining(String name);

	List<Recipe> findAllByIngredient(long id);
}

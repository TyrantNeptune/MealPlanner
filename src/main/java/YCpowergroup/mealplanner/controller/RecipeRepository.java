package YCpowergroup.mealplanner.controller;

import java.util.List;

import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends CrudRepository<Recipe,Long> {
	List<Recipe> findAllByNaamContaining(String naam);
}

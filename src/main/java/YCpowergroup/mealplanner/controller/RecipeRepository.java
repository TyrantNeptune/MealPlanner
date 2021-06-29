package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAllByNameContaining(String name);

}

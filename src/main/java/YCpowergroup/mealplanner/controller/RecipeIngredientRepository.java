package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {

    List<RecipeIngredient> findByIngredient(Ingredient ingredient);

}

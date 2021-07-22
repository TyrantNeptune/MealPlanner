package YCpowergroup.mealplanner.controller;

import java.util.List;

import YCpowergroup.mealplanner.domain.Ingredient;
import YCpowergroup.mealplanner.domain.Recipe;
import YCpowergroup.mealplanner.domain.RecipeIngredient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeRepository extends CrudRepository<Recipe,Long> {
	List<Recipe> findByNameLike(String recipename);

	List<Recipe> findByRecipeIngredientsIdIn(List<Long> recipeIngredientIds);

	List<Recipe> findByIdIn(List<Long> recipeIds);

	List<Recipe> findByBreakfastTrue();

	List<Recipe> findByLunchTrue();

	List<Recipe> findByDinnerTrue();

	List<Recipe> findDistinctRecipesByNameIn(List<String> recipeNames);
}

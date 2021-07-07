package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IngredientRepository extends CrudRepository<Ingredient,Long> {

        List<Ingredient> findAllByNameContaining(String ingredientName);

}


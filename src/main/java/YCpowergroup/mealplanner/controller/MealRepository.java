package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MealRepository extends CrudRepository<Meal, Long> {
    Meal findMealById(long Id);
}

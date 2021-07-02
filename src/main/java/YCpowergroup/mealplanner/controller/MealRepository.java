package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.MealType;
import YCpowergroup.mealplanner.domain.meal.Meal;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Long> {
    List<Meal> findMealByMealTypeAndDate(MealType mealType, LocalDate date);
}

package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Meal;
import YCpowergroup.mealplanner.domain.MealType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface MealRepository extends CrudRepository<Meal, Long> {
    List<Meal> findAllByDate(LocalDate mealDate);
    List<Meal> findAllByMealType(MealType mealType);

}

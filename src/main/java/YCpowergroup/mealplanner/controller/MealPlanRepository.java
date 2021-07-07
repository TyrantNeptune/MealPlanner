package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.MealPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface MealPlanRepository extends CrudRepository<MealPlan, Long> {

}

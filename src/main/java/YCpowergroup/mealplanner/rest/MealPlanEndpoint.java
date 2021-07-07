package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.MealPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealPlanEndpoint {
    @Autowired
    MealPlanService mealPlanService;

}

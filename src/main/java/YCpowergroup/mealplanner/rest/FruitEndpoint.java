package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.FruitService;
import YCpowergroup.mealplanner.controller.RecipeService;
import YCpowergroup.mealplanner.domain.Fruit;
import YCpowergroup.mealplanner.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitEndpoint {
    @Autowired
    FruitService fruitService;

    @GetMapping("expires/{id}")
    public long  Expires(@PathVariable int id){
        return fruitService.DaysTillExpired(id);
    }

}

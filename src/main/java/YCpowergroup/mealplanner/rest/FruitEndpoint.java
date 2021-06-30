package YCpowergroup.mealplanner.rest;

import YCpowergroup.mealplanner.controller.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FruitEndpoint {
    @Autowired
    FruitService fruitService;

    @GetMapping("expires/{id}")
    public long  Expires(@PathVariable int id){
        return fruitService.daysTillExpired(id);
    }

}

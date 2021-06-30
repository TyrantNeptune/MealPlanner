package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingredient {
    // TODO: 25/06/2021 keep or remove the annotations?
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;
    private String name;
    NutritionValues nutritionValuesPer100g;
//    @Enumerated(EnumType.STRING)
//    FoodCategory foodCategory;

    
}




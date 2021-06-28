package YCpowergroup.mealplanner.domain;

import javax.persistence.*;
import java.util.List;

//@Entity
public class Ingredient {
    // TODO: 25/06/2021 keep or remove the annotations?
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;
    private String name;
    NutritionValues nutritionValuesPer100g;
    FoodCateGory foodCateGory;

    
}


enum FoodCateGory {
    ARTIFICIAL_MEAT,
    BREAD,
    DAIRY,
    DRINK,
    FAT,
    FISH,
    FRUIT,
    GRAINS,
    MEAT,
    NOODLES,
    OIL,
    RICE,
    SNACK,
    VEGETABLE,
}

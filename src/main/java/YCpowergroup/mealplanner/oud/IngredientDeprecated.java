package YCpowergroup.mealplanner.oud;

import javax.persistence.*;

@Entity
public class IngredientDeprecated {
    // TODO: 25/06/2021 keep or remove the annotations?
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long Id;
    private String name;
    NutritionValuesDeprecated nutritionValuesDeprecatedPer100G;
//    @Enumerated(EnumType.STRING)
//    FoodCategory foodCategory;


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NutritionValuesDeprecated getNutritionValuesPer100g() {
        return nutritionValuesDeprecatedPer100G;
    }

    public void setNutritionValuesPer100g(NutritionValuesDeprecated nutritionValuesDeprecatedPer100G) {
        this.nutritionValuesDeprecatedPer100G = nutritionValuesDeprecatedPer100G;
    }
}




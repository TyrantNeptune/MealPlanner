package YCpowergroup.mealplanner.domain;

import javax.persistence.Embeddable;

@Embeddable
public class NutritionValues {
    double netCarbs;
    double carbs;
    double fats;
    double protein;
    double calories;

    NutritionValues(double netCarbs, double carbs, double fats, double protein, double calories) {
        this.netCarbs = netCarbs;
        this.carbs = carbs;
        this.fats = fats;
        this.protein = protein;
        this.calories = calories;
    }
}



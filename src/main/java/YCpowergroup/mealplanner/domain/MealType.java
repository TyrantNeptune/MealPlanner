package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MealType {
    @JsonProperty("Breakfast")
    BREAKFAST,
    @JsonProperty("Lunch")
    LUNCH,
    @JsonProperty("Dinner")
    DINNER
}
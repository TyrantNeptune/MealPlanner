package YCpowergroup.mealplanner.oud;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MealTypeDeprecated {
    @JsonProperty("Breakfast")
    BREAKFAST,
    @JsonProperty("Lunch")
    LUNCH,
    @JsonProperty("Dinner")
    DINNER
}
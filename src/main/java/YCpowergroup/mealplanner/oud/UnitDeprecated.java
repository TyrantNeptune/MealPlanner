package YCpowergroup.mealplanner.oud;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UnitDeprecated {
    @JsonProperty("Gr")
    GR,
    @JsonProperty("Ml")
    ML,
    @JsonProperty("Tbsp")
    TBSP,
    @JsonProperty("Tsp")
    TSP,
    @JsonProperty("Unit")
    UNIT

}
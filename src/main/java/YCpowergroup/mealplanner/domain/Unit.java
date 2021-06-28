package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Unit{
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
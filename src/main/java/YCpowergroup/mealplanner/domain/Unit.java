package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Unit {
    @JsonProperty("gr")
    GR,
    @JsonProperty("ml")
    ML,
    @JsonProperty("tbsp")
    TBSP,
    @JsonProperty("tsp")
    TSP,
    @JsonProperty("cup")
    CUP
}

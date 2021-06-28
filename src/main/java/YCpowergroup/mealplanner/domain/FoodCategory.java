package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum FoodCategory {
    @JsonProperty("Artificial Meat")
    ARTIFICIAL_MEAT,
    @JsonProperty("Bread")
    BREAD,
    @JsonProperty("Dairy")
    DAIRY,
    @JsonProperty("Drink")
    DRINK,
    @JsonProperty("Alcoholic Drink")
    ALCOHOLICDRINK,
    @JsonProperty("Fat/Oil")
    FATOIL,
    @JsonProperty("Fish")
    FISH,
    @JsonProperty("Fruit")
    FRUIT,
    @JsonProperty("Grains")
    GRAINS,
    @JsonProperty("Meat")
    MEAT,
    @JsonProperty("Noodles")
    NOODLES,
    @JsonProperty("Rice")
    RICE,
    @JsonProperty("Vegetable")
    VEGETABLE,
    @JsonProperty("Nuts")
    NUTS,
    @JsonProperty("Eggs")
    EGGS,
    @JsonProperty("Herbs and Spices")
    HERBSANDSPICES,
    @JsonProperty("Pantry")
    PANTRY
}
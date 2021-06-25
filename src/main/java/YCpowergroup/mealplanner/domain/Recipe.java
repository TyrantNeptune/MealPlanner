package YCpowergroup.mealplanner.domain;

import javax.persistence.*;
import java.util.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String name;
    private int servings;
    @Column(columnDefinition = "text")
    private String description;
    @Column(length = 16000)
    private String instructions;
    private List<RecipeIngredient> ingredients;
    private boolean favorite;
    private int rating;
    private List<MealType> mealTypes;
    //private NutritionValues nutritionValuesPerServing;

    public void addIngredient(double amount, String unitName) {
        RecipeIngredient ingredient = new RecipeIngredient(this, amount, unitName);
        ingredients.add(ingredient);
    }

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

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<MealType> getMealTypes() {
        return mealTypes;
    }

    public void setMealTypes(List<MealType> mealTypes) {
        this.mealTypes = mealTypes;
    }
}

enum MealType {
    BREAKFAST,
    LUNCH,
    DINNER
}

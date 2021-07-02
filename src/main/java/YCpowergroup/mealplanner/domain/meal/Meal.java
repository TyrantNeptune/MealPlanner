package YCpowergroup.mealplanner.domain.meal;

import YCpowergroup.mealplanner.domain.MealType;
import YCpowergroup.mealplanner.domain.Recipe;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private int servings;
    private LocalDate date;
    @ManyToOne
    private MealPlan mealPlan;
    @ManyToOne
    private Recipe recipe;
    @Enumerated(EnumType.STRING)
    private MealType mealType;

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MealPlan getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

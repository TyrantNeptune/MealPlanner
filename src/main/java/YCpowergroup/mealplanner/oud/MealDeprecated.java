package YCpowergroup.mealplanner.oud;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class MealDeprecated {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private int servings;
    private LocalDate date;
    @ManyToOne
    private MealPlanDeprecated mealPlanDeprecated;
    @ManyToOne
    private RecipeDeprecated recipeDeprecated;
    @Enumerated(EnumType.STRING)
    private MealTypeDeprecated mealTypeDeprecated;

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

    public MealPlanDeprecated getMealPlan() {
        return mealPlanDeprecated;
    }

    public void setMealPlan(MealPlanDeprecated mealPlanDeprecated) {
        this.mealPlanDeprecated = mealPlanDeprecated;
    }

    public RecipeDeprecated getRecipe() {
        return recipeDeprecated;
    }

    public void setRecipe(RecipeDeprecated recipeDeprecated) {
        this.recipeDeprecated = recipeDeprecated;
    }
}

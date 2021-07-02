package YCpowergroup.mealplanner.oud;

import javax.persistence.*;

@Entity
public class RecipeIngredientDeprecated {
    @ManyToOne
    private RecipeDeprecated recipeDeprecated;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private double amount;
    @ManyToOne
    private IngredientDeprecated ingredientDeprecated;
    @Enumerated(EnumType.STRING)
    private UnitDeprecated unitDeprecated;
    private String unitPrefix;

    public RecipeIngredientDeprecated(double amount, String unitName) {
        //this.recipe = recipe;
        this.amount = amount;
        this.unitDeprecated = UnitDeprecated.UNIT;
        this.unitPrefix = "";
        for (UnitDeprecated unitDeprecated : UnitDeprecated.values()) {
            if (unitDeprecated.name().equals(unitName)) {
                this.unitDeprecated = unitDeprecated;
            }
        }
        if (this.unitDeprecated == unitDeprecated.UNIT){
            this.unitPrefix = unitName;
        }
    }

    public RecipeIngredientDeprecated(){

    }

    public RecipeDeprecated getRecipe() {
        return recipeDeprecated;
    }

    public void setRecipe(RecipeDeprecated recipeDeprecated) {
        this.recipeDeprecated = recipeDeprecated;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public IngredientDeprecated getIngredient() {
        return ingredientDeprecated;
    }

    public void setIngredient(IngredientDeprecated ingredientDeprecated) {
        this.ingredientDeprecated = ingredientDeprecated;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UnitDeprecated getUnit() {
        return unitDeprecated;
    }

    public void setUnit(UnitDeprecated unitDeprecated) {
        this.unitDeprecated = unitDeprecated;
    }

    public String getUnitPrefix() {
        return unitPrefix;
    }

    public void setUnitPrefix(String unitPrefix) {
        this.unitPrefix = unitPrefix;
    }
}



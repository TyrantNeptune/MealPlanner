package YCpowergroup.mealplanner.domain;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class RecipeIngredient {
    //private Recipe recipe;
    private double amount;
    @OneToOne
    private Ingredient ingredient;
    private Unit unit;
    private String unitPrefix;

    public RecipeIngredient(double amount, Ingredient ingredient, String unitName) {
        //this.recipe = recipe;
        this.amount = amount;
        this.ingredient = ingredient;
        this.unit = Unit.UNIT;
        this.unitPrefix = "";
        for (Unit unit : Unit.values()) {
            if (unit.name().equals(unitName)) {
                this.unit=unit;
            }
        }
        if (this.unit == unit.UNIT){
            this.unitPrefix = unitName;
        }
    }

    public RecipeIngredient(){

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getUnitPrefix() {
        return unitPrefix;
    }

    public void setUnitPrefix(String unitPrefix) {
        this.unitPrefix = unitPrefix;
    }
}

enum Unit{
    GR,
    ML,
    TBSP,
    TSP,
    UNIT

}

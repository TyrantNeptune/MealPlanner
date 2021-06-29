package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @ManyToOne
    private Recipe recipe;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double amount;
    @ManyToOne
    private Ingredient ingredient;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private String unitPrefix;

    public RecipeIngredient(double amount, String unitName) {
        //this.recipe = recipe;
        this.amount = amount;
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



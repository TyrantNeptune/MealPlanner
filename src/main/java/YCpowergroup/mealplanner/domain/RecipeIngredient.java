package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category;

    @ManyToOne
    @JsonBackReference(value = "name")
    private Recipe recipe;

    @ManyToOne
    private Ingredient ingredient;

    private double amount;

    @Enumerated(EnumType.STRING)
    private Unit unit;

    //private String unitPrefix;

//    public RecipeIngredient(double amount, String unitName) {
//        //this.recipe = recipe;
//        this.amount = amount;
//        this.unitDeprecated = UnitDeprecated.UNIT;
//        this.unitPrefix = "";
//        for (UnitDeprecated unitDeprecated : UnitDeprecated.values()) {
//            if (unitDeprecated.name().equals(unitName)) {
//                this.unitDeprecated = unitDeprecated;
//            }
//        }
//        if (this.unitDeprecated == unitDeprecated.UNIT){
//            this.unitPrefix = unitName;
//        }
//    }

    public RecipeIngredient(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

//    public String getUnitPrefix() {
//        return unitPrefix;
//    }
//
//    public void setUnitPrefix(String unitPrefix) {
//        this.unitPrefix = unitPrefix;
//    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}



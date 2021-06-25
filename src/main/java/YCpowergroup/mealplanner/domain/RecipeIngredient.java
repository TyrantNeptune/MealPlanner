package YCpowergroup.mealplanner.domain;


public class RecipeIngredient {
    private Recipe recipe;
    private double amount;
    //private Ingredient ingredient;
    private Unit unit;
    private String unitPrefix;

    public RecipeIngredient(Recipe recipe, double amount, String unitName) {
        this.recipe = recipe;
        this.amount = amount;
        //this.ingredient = ingredient;
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
}

enum Unit{
    GR,
    ML,
    TBSP,
    TSP,
    UNIT

}

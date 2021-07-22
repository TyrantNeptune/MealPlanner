package YCpowergroup.mealplanner.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	private String name = "";

	private int servings;

	@Column(columnDefinition = "text")
	private String description;

	@Column(columnDefinition = "text")
	private String instructions;

	private String picture;

	private boolean breakfast;

	private boolean lunch;

	private boolean dinner;

	@OneToMany(mappedBy = "recipe")
	@JsonManagedReference(value = "name")
	private List<RecipeIngredient> recipeIngredients;

	private double carbsPerServing;

	private double netCarbsPerServing;

	private double fatsPerServing;

	private double caloriesPerServing;

	private double proteinPerServing;

	// Getters & Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return instructions; }

	public void setInstructions(String instructions) {
		this.instructions = instructions; }

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public boolean isLunch() {
		return lunch;
	}

	public void setLunch(boolean lunch) {
		this.lunch = lunch;
	}

	public boolean isDinner() {
		return dinner;
	}

	public void setDinner(boolean dinner) {
		this.dinner = dinner;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public double getCarbsPerServing() {
		return carbsPerServing;
	}

	public void setCarbsPerServing(double carbsPerServing) {
		this.carbsPerServing = carbsPerServing;
	}

	public double getNetCarbsPerServing() {
		return netCarbsPerServing;
	}

	public void setNetCarbsPerServing(double netCarbsPerServing) {
		this.netCarbsPerServing = netCarbsPerServing;
	}

	public double getFatsPerServing() {
		return fatsPerServing;
	}

	public void setFatsPerServing(double fatsPerServing) {
		this.fatsPerServing = fatsPerServing;
	}

	public double getCaloriesPerServing() {
		return caloriesPerServing;
	}

	public void setCaloriesPerServing(double caloriesPerServing) {
		this.caloriesPerServing = caloriesPerServing;
	}

	public double getProteinPerServing() {
		return proteinPerServing;
	}

	public void setProteinPerServing(double proteinPerServing) {
		this.proteinPerServing = proteinPerServing;
	}
}

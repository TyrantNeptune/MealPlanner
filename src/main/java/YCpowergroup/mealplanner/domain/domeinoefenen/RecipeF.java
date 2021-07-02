package YCpowergroup.mealplanner.domain.domeinoefenen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import YCpowergroup.mealplanner.domain.Ingredient;

@Entity
public class RecipeF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    
    
    private String naam;
    
    private String omschrijving;
    
    @OneToOne
    private IngredientF ingredient;
    
    
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public IngredientF getIngredient() {
		return ingredient;
	}
	public void setIngredient(IngredientF ingredient) {
		this.ingredient = ingredient;
	}
    
    

}

package YCpowergroup.mealplanner.domain.domeinoefenen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IngredientF {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    
    private String naam;
    private int kalorien;
    
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
	public int getKalorien() {
		return kalorien;
	}
	public void setKalorien(int kalorien) {
		this.kalorien = kalorien;
	}
    
    
}

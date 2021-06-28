package YCpowergroup.mealplanner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Fruit {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    double sappiness;
    FruitColor fruitColor;
    LocalDateTime expiryDate;

    public Fruit(){
        System.out.println("Fruit");
    }


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

    public double getSappiness() {
        return sappiness;
    }

    public void setSappiness(double sappiness) {
        this.sappiness = sappiness;
    }

    public FruitColor getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(FruitColor fruitColor) {
        this.fruitColor = fruitColor;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

}

enum FruitColor {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    PINK,
    ORANGE,
}

package YCpowergroup.mealplanner.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private LocalDate start;
    private LocalDate end;

    @OneToMany(mappedBy = "mealPlan")
    private List<Meal> meals;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}

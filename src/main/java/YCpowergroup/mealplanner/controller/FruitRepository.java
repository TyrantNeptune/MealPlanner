package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.Fruit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface FruitRepository  extends CrudRepository<Fruit, Long> {

}

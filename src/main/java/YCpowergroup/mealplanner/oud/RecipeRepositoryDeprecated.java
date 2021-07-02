package YCpowergroup.mealplanner.oud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RecipeRepositoryDeprecated extends CrudRepository<RecipeDeprecated, Long> {

    List<RecipeDeprecated> findAllByNameContaining(String name);

}

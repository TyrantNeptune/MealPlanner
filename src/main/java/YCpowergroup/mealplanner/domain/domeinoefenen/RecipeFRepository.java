package YCpowergroup.mealplanner.domain.domeinoefenen;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface RecipeFRepository extends CrudRepository<RecipeF,Long> {
	List<RecipeF> findAllByNaamContaining(String naam);
}

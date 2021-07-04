package YCpowergroup.mealplanner.controller;

import YCpowergroup.mealplanner.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

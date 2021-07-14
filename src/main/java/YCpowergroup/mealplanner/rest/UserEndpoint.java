package YCpowergroup.mealplanner.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import YCpowergroup.mealplanner.controller.UserService;
import YCpowergroup.mealplanner.domain.User;

@RestController
public class UserEndpoint {
	@Autowired
	UserService userService;
	
	@GetMapping("allusers")
	public Iterable<User> findAllUsers(){
		return userService.findAllUsers();
	}

}

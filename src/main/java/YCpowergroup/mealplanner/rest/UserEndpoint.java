package YCpowergroup.mealplanner.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("adduser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@GetMapping("finduserbyid/{userid}")
	public User findUserById(@PathVariable long userid) {
		return userService.findUserById(userid);
	}
	@DeleteMapping("deleteuserbyid/{userid}")
	public void deleteUserById(@PathVariable long userid) {
		userService.deleteUserById(userid);
	}
}

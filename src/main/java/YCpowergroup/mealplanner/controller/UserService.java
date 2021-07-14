package YCpowergroup.mealplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import YCpowergroup.mealplanner.domain.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public Iterable<User> findAllUsers(){
		return userRepository.findAll();
	}
}

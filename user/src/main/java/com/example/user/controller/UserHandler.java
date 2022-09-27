package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserHandler {
	@Autowired
	private final UserRepository userRepository;

	public UserHandler(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@GetMapping("/findAll/{index}/{limit}")
	public List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
		return userRepository.findAll(index, limit);
	}

	@GetMapping("findById/{id}")
	public User findById(@PathVariable("id") long id) {
		return userRepository.findById(id);
	}

	@GetMapping("/count")
	public int count() {
		return userRepository.count();
	}

	@PostMapping("/save")
	public void save(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		userRepository.update(user);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		userRepository.deleteById(id);
	}

}

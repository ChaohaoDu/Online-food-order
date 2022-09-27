package com.example.client.feign;

import com.example.client.entity.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@FeignClient(value = "user")
public interface UserFeign {
	@GetMapping("/user/findAll/{index}/{limit}")
	List<User> findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

	@GetMapping("/user/findById/{id}")
	User findById(@PathVariable("id") long id);


	@GetMapping("/user/count")
	int count();

	@PostMapping("/user/save")
	void save(@RequestBody User user);

	@PutMapping("/user/update")
	void update(@RequestBody User user);

	@DeleteMapping("/user/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id);
}

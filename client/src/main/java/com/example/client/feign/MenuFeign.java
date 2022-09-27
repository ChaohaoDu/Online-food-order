package com.example.client.feign;

import com.example.client.entity.Menu;
import com.example.client.entity.MenuVO;
import com.example.client.entity.Type;
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
@FeignClient(value = "menu")
public interface MenuFeign {
	@GetMapping("/menu/findAll/{index}/{limit}")
	MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);

	@DeleteMapping("/menu/deleteById/{id}")
	void deleteById(@PathVariable("id") long id);

	@GetMapping("/menu/findTypes")
	List<Type> findTypes();

	@PostMapping("/menu/save")
	void save(@RequestBody Menu menu);

	@GetMapping("/menu/findById/{id}")
	Menu findById(@PathVariable("id") long id);

	@PutMapping("/menu/update")
	void update(@RequestBody Menu menu);
}

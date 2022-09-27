package com.example.menu.controller;

import com.example.menu.entity.Menu;
import com.example.menu.entity.MenuVO;
import com.example.menu.entity.Type;
import com.example.menu.repository.MenuRepository;
import com.example.menu.repository.TypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
	@Value("${server.port}")
	private String port;

	@Autowired
	private final MenuRepository menuRepository;

	@Autowired
	private final TypeRepository typeRepository;

	public MenuHandler(MenuRepository menuRepository, TypeRepository typeRepository) {
		this.menuRepository = menuRepository;
		this.typeRepository = typeRepository;
	}

	@GetMapping("/index")
	public String index() {
		return this.port;
	}

	@GetMapping(value = "/findAll/{index}/{limit}", produces = {"application/json;charset=UTF-8"})
	public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit) {
		List<Menu> list = menuRepository.findAll(index, limit);
		return new MenuVO(0, "", menuRepository.count(), list);
	}

	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable("id") long id) {
		menuRepository.deleteById(id);
	}

	@GetMapping("/findTypes")
	public List<Type> findTypes() {
		return typeRepository.findAll();
	}

	@PostMapping("/save")
	public void save(@RequestBody Menu menu) {
		menuRepository.save(menu);
	}

	@GetMapping("/findById/{id}")
	public Menu findById(@PathVariable("id") long id) {
		return menuRepository.findById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Menu menu) {
		System.out.println(menu);
		menuRepository.update(menu);
	}
}

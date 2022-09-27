package com.example.client.controller;

import com.example.client.entity.User;
import com.example.client.entity.UserVO;
import com.example.client.feign.UserFeign;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserHandler {
	private final UserFeign userFeign;

	public UserHandler(UserFeign userFeign) {
		this.userFeign = userFeign;
	}

	@GetMapping("/redirect/{location}")
	public String redirect(@PathVariable("location") String location) {
		return location;
	}

	@GetMapping("/findAll")
	@ResponseBody
	public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		int index = (page - 1) * limit;
		return new UserVO(0, "", userFeign.count(), userFeign.findAll(index, limit));
	}

	@GetMapping("findById/{id}")
	public User findById(@PathVariable("id") long id) {
		return userFeign.findById(id);
	}

	@GetMapping("/count")
	public int count() {
		return userFeign.count();
	}

	@PostMapping("/save")
	public String save(User user) {
		user.setRegisterdate(new Date());
		userFeign.save(user);
		return "redirect:/menu/redirect/user_manage";

	}

	@GetMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") long id) {
		userFeign.deleteById(id);
		return "redirect:/menu/redirect/user_manage";
	}

}

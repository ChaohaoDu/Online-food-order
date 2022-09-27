package com.example.client.controller;

import com.example.client.entity.Admin;
import com.example.client.entity.User;
import com.example.client.feign.AccountFeign;
import java.util.LinkedHashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountHandler {
	@Autowired
	AccountFeign accountFeign;

	public AccountHandler(AccountFeign accountFeign) {
		this.accountFeign = accountFeign;
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
	   @RequestParam("type") String type, HttpSession session) {

		Object object = accountFeign.login(username, password, type);
		LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) object;

		String res = null;

		if (object == null) {
			res = "login";
		} else {
			long id = Long.parseLong(map.get("id") + "");
			switch (type) {
				case "user":
					User user = new User();
					user.setId(id);
					user.setNickname((String) map.get("nickname"));
					session.setAttribute("user", user);
					res = "index";
					break;
				case "admin":
					Admin admin = new Admin();
					admin.setId(id);
					admin.setUsername((String) map.get("username"));
					session.setAttribute("admin", admin);
					res = "main";
					break;
			}
		}
		return res;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login.html";
	}
}

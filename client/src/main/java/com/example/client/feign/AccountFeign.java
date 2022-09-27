package com.example.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
@FeignClient(value = "account")
public interface AccountFeign {
	@GetMapping("/account/login/{username}/{password}/{type}")
	Object login(@PathVariable("username") String username, @PathVariable("password") String password,
	   @PathVariable("type") String type);
}

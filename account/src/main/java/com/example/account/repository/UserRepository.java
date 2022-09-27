package com.example.account.repository;

import com.example.account.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	User login(String username, String password);
}

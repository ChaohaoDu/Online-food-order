package com.example.account.repository;

import com.example.account.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository {
	Admin login(String username, String password);
}

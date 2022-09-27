package com.example.user.repository;

import com.example.user.entity.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	List<User> findAll(int index, int limit);

	User findById(long id);

	int count();

	void save(User user);

	void update(User user);

	void deleteById(long id);
}

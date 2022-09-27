package com.example.menu.repository;

import com.example.menu.entity.Type;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository {
	Type findById(long id);

	List<Type> findAll();
}

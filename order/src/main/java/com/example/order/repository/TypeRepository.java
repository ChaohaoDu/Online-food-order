package com.example.order.repository;

import com.example.order.entity.Type;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository {
	Type findById(long id);

	List<Type> findAll();
}

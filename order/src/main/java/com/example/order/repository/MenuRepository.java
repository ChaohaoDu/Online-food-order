package com.example.order.repository;

import com.example.order.entity.Menu;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository {
	List<Menu> findAll(int index, int limit);

	int count();

	Menu findById(long id);

	void save(Menu menu);

	void update(Menu menu);

	void deleteById(long id);
}

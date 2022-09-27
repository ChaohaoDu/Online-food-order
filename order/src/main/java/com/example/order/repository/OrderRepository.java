package com.example.order.repository;

import com.example.order.entity.Order;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
//	void save(Order order);
//
//	List<Order> findAllByUid(int index, int limit, long uid);
//
//	int countByUid(long id);
//
//	List<Order> findAllByState(int state, int index, int limit);
//
//	void updateState(long id);
//
//	int countByState();

	public void save(Order order);

	public List<Order> findAllByUid(long uid, int index, int limit);

	public int countByUid(long uid);

	public void deleteByMid(long mid);

	public void deleteByUid(long uid);

	public List<Order> findAllByState(int state, int index, int limit);

	public int countByState(int state);

	public void updateState(long id, long aid, int state);
}

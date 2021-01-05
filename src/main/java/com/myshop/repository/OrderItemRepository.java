package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.OrderItem;
import com.myshop.entity.Orders;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

	OrderItem findByOrderitemId(int orderItemId);
	List<OrderItem> findByOrders(Orders order);
	
}

package com.myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myshop.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

	Orders findByOrderId(int orderId);
	
}

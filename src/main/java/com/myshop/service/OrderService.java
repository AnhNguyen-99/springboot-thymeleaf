package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.OrderConverter;
import com.myshop.dto.OrderDTO;
import com.myshop.entity.Orders;
import com.myshop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<OrderDTO> getAll(){
		List<OrderDTO> listDTO = new ArrayList<>();
		List<Orders> list = orderRepository.findAll();
		OrderConverter orderConverter = new OrderConverter();
		for (Orders orders : list) {
			OrderDTO orderDTO = orderConverter.toOrderDTO(orders);
			listDTO.add(orderDTO);
		}
		return listDTO;
	}
	
	public OrderDTO findById(int orderId) {
		OrderConverter orderConverter = new OrderConverter();
		Orders orders = orderRepository.findByOrderId(orderId);
		return orderConverter.toOrderDTO(orders);
	}
	
	public OrderDTO save(OrderDTO orderDTO) {
		Orders orders = new Orders();
		Orders oldOrders = new Orders();
		OrderConverter orderConverter = new OrderConverter();
		if(orderDTO.getOrderId() != null) {
			oldOrders = orderRepository.findByOrderId(orderDTO.getOrderId());
			orders = orderConverter.toOrderEntity(oldOrders, orderDTO);
		}else {
			orders = orderConverter.toOrderEntity(orderDTO);
		}
		orders = orderRepository.save(orders);
		return orderConverter.toOrderDTO(orders);
	}
}

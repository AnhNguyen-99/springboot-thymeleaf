package com.myshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshop.converter.OrderItemConverter;
import com.myshop.dto.OrderItemDTO;
import com.myshop.entity.OrderItem;
import com.myshop.entity.Orders;
import com.myshop.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItemDTO> getAll(){
		List<OrderItemDTO> listDTO = new ArrayList<>();
		List<OrderItem> list = orderItemRepository.findAll();
		OrderItemConverter orderItemConverter = new OrderItemConverter();
		for (OrderItem orderItem : list) {
			OrderItemDTO orderItemDTO = orderItemConverter.toOrderItemDTO(orderItem);
			listDTO.add(orderItemDTO);
		}
		return listDTO;
	}
	
	public List<OrderItemDTO> findByOrderId(int orderId){
		List<OrderItemDTO> listDTO = new ArrayList<>();
		Orders orders = new Orders(orderId);
		List<OrderItem> list = orderItemRepository.findByOrders(orders);
		OrderItemConverter orderItemConverter = new OrderItemConverter();
		for (OrderItem orderItem : list) {
			OrderItemDTO orderItemDTO = orderItemConverter.toOrderItemDTO(orderItem);
			listDTO.add(orderItemDTO);
		}
		return listDTO;
	}
	 
}

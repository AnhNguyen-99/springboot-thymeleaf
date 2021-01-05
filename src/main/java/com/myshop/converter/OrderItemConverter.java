package com.myshop.converter;

import com.myshop.dto.OrderItemDTO;
import com.myshop.entity.OrderItem;
import com.myshop.entity.Orders;
import com.myshop.entity.Product;

public class OrderItemConverter {

	public OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		orderItemDTO.setOrderItemId(orderItem.getOrderitemId());
		orderItemDTO.setOrderId(orderItem.getOrders().getOrderId());
		orderItemDTO.setPrice(orderItem.getPrice());
		orderItemDTO.setProductId(orderItem.getProduct().getProductId());
		orderItemDTO.setQuantity(orderItem.getQuantity());
		return orderItemDTO;
	}
	
	public OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO) {
		OrderItem orderItem = new OrderItem();
		Orders orders = new Orders(orderItemDTO.getOrderId());
		orderItem.setOrders(orders);
		Product product = new Product(orderItemDTO.getProductId());
		orderItem.setProduct(product);
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItem.getQuantity());
		return orderItem;
	}
	
	public OrderItem toOrderItemEntity(OrderItem orderItem, OrderItemDTO orderItemDTO) {
		Orders orders = new Orders(orderItemDTO.getOrderId());
		orderItem.setOrders(orders);
		Product product = new Product(orderItemDTO.getProductId());
		orderItem.setProduct(product);
		orderItem.setPrice(orderItemDTO.getPrice());
		orderItem.setQuantity(orderItem.getQuantity());
		return orderItem;
	}
}

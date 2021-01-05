package com.myshop.converter;

import com.myshop.dto.OrderDTO;
import com.myshop.entity.Account;
import com.myshop.entity.Orders;
import com.myshop.entity.StatusOrder;

public class OrderConverter {

	public OrderDTO toOrderDTO(Orders orders) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrderId(orders.getOrderId());
		orderDTO.setOrderName(orders.getOrderName());
		orderDTO.setMail(orders.getMail());
		orderDTO.setPhone(orders.getPhone());
		orderDTO.setAddress(orders.getAddress());
		orderDTO.setTotalPrice(orders.getTotalPrice());
		orderDTO.setStatusOrderId(orders.getStatusorder().getStatusId());
		orderDTO.setOrderDate(orders.getOrderDate());
		orderDTO.setReceiveDate(orders.getReceiveDate());
		orderDTO.setAccountId(orders.getAccount().getAccountId());
		orderDTO.setAccountName(orders.getAccount().getAccountName());
		return orderDTO;
	}
	
	public Orders toOrderEntity(OrderDTO orderDTO) {
		Orders orders = new Orders();
		orders.setOrderName(orderDTO.getOrderName());
		orders.setMail(orderDTO.getMail());
		orders.setPhone(orderDTO.getPhone());
		orders.setAddress(orderDTO.getAddress());
		orders.setTotalPrice(orderDTO.getTotalPrice());
		StatusOrder statusOrder = new StatusOrder(orderDTO.getStatusOrderId());
		orders.setStatusorder(statusOrder);
		orders.setOrderDate(orderDTO.getOrderDate());
		orders.setReceiveDate(orderDTO.getReceiveDate());
		Account account = new Account(orderDTO.getAccountId());
		orders.setAccount(account);
		return orders;
	}
	
	public Orders toOrderEntity(Orders orders, OrderDTO orderDTO) {
		orders.setOrderName(orderDTO.getOrderName());
		orders.setMail(orderDTO.getMail());
		orders.setPhone(orderDTO.getPhone());
		orders.setAddress(orderDTO.getAddress());
		orders.setTotalPrice(orderDTO.getTotalPrice());
		StatusOrder statusOrder = new StatusOrder(orderDTO.getStatusOrderId());
		orders.setStatusorder(statusOrder);
		orders.setOrderDate(orderDTO.getOrderDate());
		orders.setReceiveDate(orderDTO.getReceiveDate());
		Account account = new Account(orderDTO.getAccountId());
		orders.setAccount(account);
		return orders;
	}
}

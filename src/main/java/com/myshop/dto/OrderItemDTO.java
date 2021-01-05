package com.myshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

	private int orderItemId;
	private int quantity;
	private double price;
	private int productId;
	private int orderId;
}

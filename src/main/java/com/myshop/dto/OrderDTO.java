package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Integer orderId;
	private String orderName;
	private String mail;
	private String phone;
	private String address;
	private Double totalPrice;
	private Date orderDate;
	private Date receiveDate;
	private int accountId;
	private int statusOrderId;
	private String accountName;
	
}

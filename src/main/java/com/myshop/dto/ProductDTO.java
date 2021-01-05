package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private int productId;
	private String productName;
	private String productImage;
	private Double productPrice;
	private int productSale;
	private String content;
	private String productDescription;
	private boolean status;
	private Date createDate;
	private Date updateDate;
	private int accountId;
	private int categoryId;
	private int producerId;
	
}

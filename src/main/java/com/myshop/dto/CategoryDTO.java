package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

	private Integer categoryId;
	private String categoryName;
	private Boolean status;
	private Date createDate;
	private Date updateDate;
	private int accountId;
	private String accountName;
}

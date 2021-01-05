package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {

	private Integer newsId;
	private String title;
	private String content;
	private String image;
	private Boolean status;
	private Date createDate;
	private int accountId;
	private String accountName;
	
}

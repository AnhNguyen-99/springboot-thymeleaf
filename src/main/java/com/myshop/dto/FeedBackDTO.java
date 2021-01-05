package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDTO {

	private Integer feedBackId;
	private String username;
	private String mobile;
	private String email;
	private String address;
	private String content;
	private Date createDate;
	private Date updateDate;
	
}

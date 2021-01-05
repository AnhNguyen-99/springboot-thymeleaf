package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	private Integer accountId;
	private String accountName;
	private String accountPass;
	private String fullName;
	private String address;
	private String mobile;
	private String mail;
	private Boolean status;
	private Date createDate;
	private Date updateDate;
	
}

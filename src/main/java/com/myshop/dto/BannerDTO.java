package com.myshop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerDTO {

	private Integer bannerId;
	private String image;
	private Boolean status;
	private Date createDate;
	private Date updateDate;
}

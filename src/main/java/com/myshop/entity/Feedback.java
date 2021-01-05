package com.myshop.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback implements Serializable {

	private static final long serialVersionUID = 2569196468866493298L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id", unique = true, nullable = false)
	private int feedbackId;
	
	@Column(name = "username", nullable = false, length = 100)
	private String username;
	
	@Column(name = "mobile", nullable = false, length = 10)
	private String mobile;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "content", nullable = false, length = 65535)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 26)
	private Date updateDate;

}

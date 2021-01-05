package com.myshop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "news", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {

	private static final long serialVersionUID = 92676722153237289L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "news_id", unique = true, nullable = false)
	private int newsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false, length = 65535)
	private String content;
	
	@Column(name = "image", nullable = false, length = 100)
	private String image;
	
	@Column(name = "status")
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;

}

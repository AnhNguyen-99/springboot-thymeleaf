package com.myshop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = -8272151157544705746L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	private int productId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producer_id", nullable = false)
	private Producer producer;
	
	@Column(name = "product_name", nullable = false)
	private String productName;

	@Column(name = "product_image", nullable = false, length = 100)
	private String productImage;

	@Column(name = "product_price", nullable = false, precision = 22, scale = 0)
	private double productPrice;
	
	@Column(name = "product_sale")
	private Integer productSale;
	
	@Column(name = "content", length = 65535)
	private String content;
	
	@Column(name = "product_description", length = 65535)
	private String productDescription;
	
	@Column(name = "status")
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;
	
	@Column(name = "update_date", length = 26)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private Set<OrderItem> orderitems = new HashSet<OrderItem>(0);

	public Product(int productId) {
		this.productId = productId;
	}
}

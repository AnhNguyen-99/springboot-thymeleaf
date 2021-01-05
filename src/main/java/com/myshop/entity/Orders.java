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
@Table(name = "orders", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

	private static final long serialVersionUID = -2894322292914711246L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	private int orderId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_status", nullable = false)
	private StatusOrder statusorder;
	
	@Column(name = "order_name", nullable = false, length = 100)
	private String orderName;
	
	@Column(name = "mail", nullable = false, length = 100)
	private String mail;
	
	@Column(name = "address", nullable = false, length = 100)
	private String address;
	
	@Column(name = "phone", nullable = false, length = 10)
	private String phone;
	
	@Column(name = "total_price", nullable = false, precision = 22, scale = 0)
	private double totalPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date", length = 26)
	private Date orderDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "receive_date", length = 26)
	private Date receiveDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orders")
	private Set<OrderItem> orderitems = new HashSet<OrderItem>(0);

	public Orders(int orderId) {
		this.orderId = orderId;
	}
}

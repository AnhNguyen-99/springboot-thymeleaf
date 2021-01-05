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
@Table(name = "producer", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producer implements Serializable {

	private static final long serialVersionUID = 2046378829890725773L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "producer_id", unique = true, nullable = false)
	private int producerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;
	
	@Column(name = "producer_name", nullable = false, length = 100)
	private String producerName;

	@Column(name = "status")
	private Boolean status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 26)
	private Date updateDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producer")
	private Set<Product> products = new HashSet<Product>(0);

	public Producer(int producerId) {
		this.producerId = producerId;
	}
}

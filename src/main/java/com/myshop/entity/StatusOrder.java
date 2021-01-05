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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statusorder", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusOrder implements Serializable {

	private static final long serialVersionUID = 2901553523877853141L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "status_id", unique = true, nullable = false)
	private int statusId;
	
	@Column(name = "status_name", nullable = false, length = 100)
	private String statusName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 26)
	private Date updateDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "statusorder")
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public StatusOrder(int statusId) {
		this.statusId = statusId;
	}
}

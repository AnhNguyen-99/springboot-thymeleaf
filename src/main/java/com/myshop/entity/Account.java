package com.myshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

	private static final long serialVersionUID = -2960719691717463614L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "account_id", unique = true, nullable = false)
	private Integer accountId;

	@Column(name = "account_name", nullable = false, length = 100)
	private String accountName;

	@Column(name = "account_pass", nullable = false, length = 100)
	private String accountPass;

	@Column(name = "full_name", nullable = false)
	private String fullName;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "mail", nullable = false, length = 100)
	private String mail;

	@Column(name = "mobile", nullable = false, length = 10)
	private String mobile;

	@Column(name = "status")
	private Boolean status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 26)
	private Date updateDate;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Orders> orderses = new HashSet<Orders>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Producer> producers = new HashSet<Producer>(0);

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "account_role", catalog = "myshop_2", joinColumns = {
//			@JoinColumn(name = "account_id", nullable = false, updatable = false) }, inverseJoinColumns = {
//					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
//	private Set<Role> roles = new HashSet<Role>(0);

	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<News> newses = new HashSet<News>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Product> products = new HashSet<Product>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Category> categories = new HashSet<Category>(0);

	public Account(Integer accountId) {
		this.accountId = accountId;
	}
}

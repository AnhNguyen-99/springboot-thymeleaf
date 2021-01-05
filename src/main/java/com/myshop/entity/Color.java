package com.myshop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "color", catalog = "myshop_2")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Color implements Serializable {

	private static final long serialVersionUID = 8648379014589952915L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "color_id", unique = true, nullable = false)
	private int colorId;

	@Column(name = "color_name", nullable = false, length = 100)
	private String colorName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 26)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", length = 26)
	private Date updateDate;

}

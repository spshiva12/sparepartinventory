package com.spi.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "sale_product", joinColumns = @JoinColumn(name = "sid"), inverseJoinColumns = @JoinColumn(name = "pid"))
	private List<Product> product;
	private String cname;
	private Date date;
	private double amount;
}
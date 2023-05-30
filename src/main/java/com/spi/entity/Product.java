package com.spi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	@Positive(message = "part number must be a positive")
	private Long partNumber;
	@NotNull(message = "partdescription can not be null")
	private String partDescription;
	@Positive(message = "CostPerUnit must be positive integer")
	private Integer costPerUnit;
	@Positive(message = "quantity must be a positive integer")
	private Integer quantity;
}
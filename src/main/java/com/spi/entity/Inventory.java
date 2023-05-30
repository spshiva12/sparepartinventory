package com.spi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long partNumber;
	@NotBlank(message = "part description is mandatory:")
	private String partDescription;
	@NotBlank(message = "supplier name is mandatory")
	private String supplierName;
	@PositiveOrZero(message = "Quantity in stack must be positive or zero")
	private Integer quantityInStock;
	@Positive(message = "Minimum stock level must be positive")
	private Integer minimumStockLevel;
	@Positive(message = "cost per unit must be positive")
	private Integer costPerUnit;
	@NotBlank(message = "location in warehouse is mandatory")
	private String locationInWarehouse;
}
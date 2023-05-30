package com.spi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Supplier name (unique identifier)
//Contact name
//Contact phone number
//Contact email address
//Address

//Lead time

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUPLIER")
public class SupplierEntity {
	@Id
	@GenericGenerator(name = "myGenerator", strategy = "increment")
	@GeneratedValue(generator = "myGenerator", strategy = GenerationType.AUTO)
	private int id;
    @NotNull(message = "suppliername cannot be null")
    @NotBlank(message = "suppliername cannot be blank")
	private String supplierName;

    @NotNull(message = "contactname cannot be null")
    @NotBlank(message = "contactname cannot be blank")
	private String contactName;

//    @Pattern(regexp = "\\d{10}")
	private long mobNumber;

    @Email(message = "Email address must be a valid email address")
	private String email;

    @NotNull(message = "address cannot be null")
    @NotBlank(message = "address cannot be blank")
	private String address;

    @Positive(message = "LeadTime must be a positive Integer")
	private int leadTime;
	//@Pattern(regexp = "\\d{2}[A-Z]{5}\\d{4}[A-Z]{1}\\d[Z]{1}[A-Z\\d]{1}")
    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$",message = "GSTIN must be a valid GSTIN number")
	private String gstinNo;

}

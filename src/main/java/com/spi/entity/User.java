package com.spi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	@NotBlank(message = "username is required")
	private String username;
	@NotBlank(message = "password is required")
	private String password;
	@Email(message = "email should be valid")
	@NotBlank(message = "email is required")
	private String email;
	@Column(name = "first_name")
	@NotBlank(message = "firstname is required")
	private String firstname;
	@Column(name = "last_name")
	@NotBlank(message = "lastname is required")
	private String lastname;
	@Column(nullable = false)
    private String roles;

}

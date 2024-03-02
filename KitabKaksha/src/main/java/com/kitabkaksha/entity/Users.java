package com.kitabkaksha.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@NotBlank(message = "Username cannot be blank")
	@Size(max = 25, message = "Username must be at most 25 characters")
	private String userName;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Invalid email address")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 4, message = "Password must be at least 4 characters")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@NotBlank(message = "Role cannot be blank")
	private String role;
	private boolean isActive;
	@JsonIgnore
	@OneToOne
	private Carts cart;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	private Set<Books> ownedBooks = new HashSet<>();
}

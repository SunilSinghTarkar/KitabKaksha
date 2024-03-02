package com.kitabkaksha.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@NotBlank(message = "Book Name cannot be blank")
	@Size(max = 25, message = "Book Name must be at most 25 characters")
	private String title;

	@NotBlank(message = "Author Name cannot be blank")
	@Size(max = 25, message = "Author Name must be at most 25 characters")
	private String author;

	@NotBlank(message = "Genre cannot be blank")
	@Size(max = 20, message = "Genre must be at most 20 characters")
	private String genre;

	@NotBlank(message = "Description cannot be blank")
	@Size(max = 50, message = "Description must be at most 50 characters")
	private String description;

	@Positive(message = "Price must be a positive value")
	private double price;

	private String imageUrl;

	@Positive(message = "Quantity must be a positive value")
	private int quantity;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String publisher;
	@JsonIgnore
	@OneToMany(mappedBy = "bookId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reviews> reviews = new ArrayList<>();
}

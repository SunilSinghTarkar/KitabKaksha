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
import lombok.Data;

@Data
@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String title;
	private String author;
	private String genre;
	private String description;
	private double price;
	private String imageUrl;
	private int quantity;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String publisher;
	@JsonIgnore
	@OneToMany(mappedBy = "bookId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Reviews> reviews = new ArrayList<>();
}

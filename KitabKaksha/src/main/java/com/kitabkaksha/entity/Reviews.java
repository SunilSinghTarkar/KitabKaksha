package com.kitabkaksha.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	@Min(value = 1, message = "Rating must be at least 1")
	@Max(value = 5, message = "Rating must be at most 5")
	private int rating;

	@Size(max = 50, message = "Description must be at most 50 characters")
	private String description;
	@JsonIgnore
	@NotNull(message = "User ID cannot be null")
	@ManyToOne
	private Users userId;
	@JsonIgnore
	@NotNull(message = "Book ID cannot be null")
	@ManyToOne
	private Books bookId;
	private LocalDateTime timeStamp;

}

package com.kitabkaksha.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	@JsonIgnore
	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Users user;
	 @ManyToMany
	    @JoinTable(
	        name = "cart_books", 
	        joinColumns = @JoinColumn(name = "cart_id"), 
	        inverseJoinColumns = @JoinColumn(name = "book_id")
	    )
	    private List<Books> bookList = new ArrayList<>();
	

	 
	 
}

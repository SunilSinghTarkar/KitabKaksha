package com.kitabkaksha.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Discussions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String topic;
	private String userName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Messages> messages = new ArrayList<>();
	private Boolean isActive;
}

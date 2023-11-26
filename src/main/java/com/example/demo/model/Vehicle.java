package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Nombres no puede estar vacio")
	@NotBlank(message = "Nombres no puede ser nulo")
	private String Make;

	@NotNull(message = "Nombres no puede estar vacio")
	@NotBlank(message = "Nombres no puede ser nulo")
	private String Model;

	@NotNull(message = "Nombres no puede estar vacio")
	@NotBlank(message = "Nombres no puede ser nulo")
	private String Year;

	@NotNull(message = "Nombres no puede estar vacio")
	@NotBlank(message = "Nombres no puede ser nulo")
	private String License;

	@JsonBackReference
	@ManyToOne(optional = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "client_id")
	private Client client;

	public Vehicle() {
	}

	public Vehicle(Long id,
			@NotNull(message = "Nombres no puede estar vacio") @NotBlank(message = "Nombres no puede ser nulo") String make,
			@NotNull(message = "Nombres no puede estar vacio") @NotBlank(message = "Nombres no puede ser nulo") String model,
			@NotNull(message = "Nombres no puede estar vacio") @NotBlank(message = "Nombres no puede ser nulo") String year,
			@NotNull(message = "Nombres no puede estar vacio") @NotBlank(message = "Nombres no puede ser nulo") String license,
			Client client) {
		super();
		this.id = id;
		Make = make;
		Model = model;
		Year = year;
		License = license;
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getLicense() {
		return License;
	}

	public void setLicense(String license) {
		License = license;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}

package com.example.demo.model;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String Paternal;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String Maternal;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String DocumentType;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String IdNumber;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String Date;

//	@NotNull(message = "Nombres no puede estar vacio")
//	@NotBlank(message = "Nombres no puede ser nulo")
	private String Gender;

	@JsonManagedReference
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Set<Vehicle> vehicle = new HashSet<>();

	public Client() {
	}

	public Client(Long id, String name, String paternal, String maternal, String documentType, String idNumber,
			String date, String gender, Set<Vehicle> vehicle) {
		super();
		this.id = id;
		Name = name;
		Paternal = paternal;
		Maternal = maternal;
		DocumentType = documentType;
		IdNumber = idNumber;
		Date = date;
		Gender = gender;
		this.vehicle = vehicle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPaternal() {
		return Paternal;
	}

	public void setPaternal(String paternal) {
		Paternal = paternal;
	}

	public String getMaternal() {
		return Maternal;
	}

	public void setMaternal(String maternal) {
		Maternal = maternal;
	}

	public String getDocumentType() {
		return DocumentType;
	}

	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}

	public String getIdNumber() {
		return IdNumber;
	}

	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Set<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Set<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
}

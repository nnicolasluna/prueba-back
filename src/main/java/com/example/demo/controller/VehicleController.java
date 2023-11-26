package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins= {"http://localhost:4200"})	
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	// GET
	@GetMapping("/vehicles")
	public List<Vehicle> ListAll() {
		return vehicleService.getAllVehicle();
	}

	@GetMapping("/{id}")
	public Vehicle findVehicleById(@PathVariable("id") Long id) {
		return vehicleService.getVehicleById(id);
	}
	
	@GetMapping("client/{id}")
	public List<Vehicle> findVehicleByIdClient(@PathVariable("id") Long id) {
		return vehicleService.getVehicleByIdClient(id);
	}

	// POST
	@PostMapping
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {
		return vehicleService.createVehicle(vehicle);
	}

	// PUT
	@PutMapping("edit/{id}")
	public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle, @PathVariable Long id) {
		vehicle.setId(id);
		return vehicleService.updateVehicle(vehicle);
	}

	// DELETE
	@DeleteMapping("delete/{id}")
	public void deleteVehicle(@PathVariable Long id) {
		vehicleService.deleteVehicletById(id);
	}

}

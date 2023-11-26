package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	// Mostrar todos los Vehiculos
	public List<Vehicle> getAllVehicle() {
		return vehicleRepository.findAll();
	}

	// Mostrar Vehiculos por ID
	public Vehicle getVehicleById(Long id) {
		Optional<Vehicle> Vehicle = vehicleRepository.findById(id);
		Vehicle vehicle = null;
		if (Vehicle.isPresent()) {
			vehicle = Vehicle.get();
		}
		return vehicle;
	}

	// Mostrar Vehiculos por ID de Cliente
	public List<Vehicle> getVehicleByIdClient(Long id) {
		return vehicleRepository.searchByIdClientQueryNative(id);
	}

	// Crear Vehiculo
	public Vehicle createVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	// Editar por ID de Vehiculo
	public Vehicle updateVehicle(Vehicle vehicle) {
		Optional<Vehicle> Vehicle = vehicleRepository.findById(vehicle.getId());
		if (Vehicle.isPresent()) {
			return vehicleRepository.save(vehicle);
		} else {
			return null;
		}

	}

	// Eliminar por ID de Vehiculo
	public void deleteVehicletById(Long id) {
		Optional<Vehicle> Vehicle = vehicleRepository.findById(id);
		Vehicle vehicle = null;
		if (Vehicle.isPresent()) {
			vehicle = Vehicle.get();
			vehicleRepository.delete(vehicle);
		}
	}

}

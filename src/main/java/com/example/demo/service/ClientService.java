package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	// Mostrar todos los Clientes
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}
	
	// Mostrar Vehiculos por ID de Cliente
	public List<Vehicle> getVehicleByIdClient(Long id) {
		return clientRepository.searchByClientIdQueryNative(id);
	}
	
	// Mostrar Cliente por ID
	public Client getClientById(Long id) {
		Optional<Client> Client = clientRepository.findById(id);
		Client client = null;
		if (Client.isPresent()) {
			client = Client.get();
		}
		return client;
	}
	
	// Crear Cliente
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}

	// Editar por ID de Cliente
	public Client updateClient(Client client) {
		Optional<Client> Client = clientRepository.findById(client.getId());
		if (Client.isPresent()) {
			return clientRepository.save(client);
		} else {
			return null;
		}

	}

	// Eliminar por ID de Cliente
	public void deleteClientById(Long id) {
		Optional<Client> Client = clientRepository.findById(id);
		Client client = null;
		if (Client.isPresent()) {
			client = Client.get();
			clientRepository.delete(client);
		}
	}
	
	

}

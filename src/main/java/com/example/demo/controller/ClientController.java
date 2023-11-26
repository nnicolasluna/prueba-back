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

import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;
import com.example.demo.service.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins= {"http://localhost:4200"})	
public class ClientController {

	@Autowired
	private ClientService clientService;

	// GET
	@GetMapping("clients")
	public List<Client> ListAll() {
		return clientService.getAllClient();
	}

	@GetMapping("/{id}")
	public Client findClientById(@PathVariable("id") Long id) {
		return clientService.getClientById(id);
	}
	
	@GetMapping("vehicles/{id}")
	public List<Vehicle> getVehicleByIdClient(@PathVariable("id") Long id) {
		return clientService.getVehicleByIdClient(id);
	}

	// POST
	@PostMapping
	public Client createClient(@Valid @RequestBody Client client) {
		return clientService.createClient(client);
	}

	// PUT
	@PutMapping("edit/{id}")
	public Client updateClient(@Valid @RequestBody Client client, @PathVariable Long id) {
		client.setId(id);
		return clientService.updateClient(client);
	}

	// DELETE
	@DeleteMapping("delete/{id}")
	public void deleteClient(@PathVariable Long id) {
		clientService.deleteClientById(id);
	}

}

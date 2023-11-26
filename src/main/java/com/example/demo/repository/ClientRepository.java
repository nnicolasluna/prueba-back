package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Client;
import com.example.demo.model.Vehicle;

public interface ClientRepository extends JpaRepository<Client, Long> {
	
	@Query(value = "select * from vehicle where client_id=:id", nativeQuery = true)
	List<Vehicle> searchByClientIdQueryNative(Long id);

}

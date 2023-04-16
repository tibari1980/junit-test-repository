package com.arcesi.gestionemployee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arcesi.gestionemployee.entities.EmployeBean;
import com.arcesi.gestionemployee.repositories.EmployeeRepository;

@SpringBootApplication
public class MicroServiceEmployeTestRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceEmployeTestRepositoryApplication.class, args);
	}
	
	 
 	

}

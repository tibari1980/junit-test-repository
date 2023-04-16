package com.arcesi.gestionemployee.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcesi.gestionemployee.entities.EmployeBean;

@Repository
public interface EmployeeRepository  extends JpaRepository<EmployeBean, Long>{

	List<EmployeBean> findByFirstNameContainsIgnoreCase(String partialName);
	List<EmployeBean> findByLastNameContainsIgnoreCase(String partialLastName);
	List<EmployeBean> findByEmailContainsIgnoreCase(String partialEmail);
	List<EmployeBean> findByFirstNameContainsOrLastNameContainsOrEmailContainsAllIgnoreCase(String partailFirstName,String partialLastName,String partialEmail);
	List<EmployeBean> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String partialFirstName, String partialLastName);
	
	List<EmployeBean> findByAgeGreaterThan(int age);
	List<EmployeBean> findByAgeGreaterThanEqual(int ag);
	List<EmployeBean> findByAgeLessThanEqual(int age);
	
	EmployeBean  findByEmailIgnoreCase(String email);
	
	List<EmployeBean> findByFirstNameIgnoreCase(String firstName);
	List<EmployeBean> findByLastNameIgnoreCase(String lastName);
	List<EmployeBean> findByAge(int age);
	
}

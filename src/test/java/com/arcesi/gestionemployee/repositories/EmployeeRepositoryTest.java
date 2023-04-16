package com.arcesi.gestionemployee.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.arcesi.gestionemployee.entities.EmployeBean;

import lombok.AllArgsConstructor;



@DataJpaTest
public class EmployeeRepositoryTest {

	
	@Autowired
	EmployeeRepository employeeRepository;

	@BeforeEach
	 void setUp() {

		EmployeBean tibari = EmployeBean.builder().firstName("Tibari").lastName("Zeroual").age(42)
				.email("tibarinewdzigh@gmail.com").build();
		EmployeBean tarik = EmployeBean.builder()
				.firstName("tarik").lastName("zeroual").age(45).email("zeroual.t@gmail.com").build();
		EmployeBean souad = EmployeBean.builder()
				 .firstName("souad").lastName("zeroual").age(40).email("zeroualsouad@gmail.com") .build();
		EmployeBean lyna = EmployeBean.builder()
				.firstName("kazzar").lastName("lyna").age(20).email("lynakazzar@gmail.com") .build();
		EmployeBean hamza = EmployeBean.builder()
				.firstName("zeroual").lastName("hamza").age(33).email("hamza@gmail.com") .build();
		employeeRepository.saveAllAndFlush(List.of(tibari,tarik,souad,lyna,hamza));
	}

	@Test
	public void findAllshouldProduceAllEmploye() {
		List<EmployeBean> employeBeans=employeeRepository.findAll();
		assertThat(employeBeans).hasSize(5);
	}
	
	@Test
	public void findByFirstNameShouldRetrieveOneEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByFirstNameContainsIgnoreCase("azz");
		assertThat(employeBeans).hasSize(1);
		assertThat(employeBeans).extracting(EmployeBean::getFirstName).containsExactly("kazzar");
	}

	
	@Test
	public void findByLastNameShouldRetrieveOneEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByLastNameContainsIgnoreCase("zer");
		assertThat(employeBeans).hasSize(3);
	}
	
	@Test
	public void findByEmailShouldRetrieveOneEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByEmailContainsIgnoreCase("tibarinewd");
		assertThat(employeBeans).hasSize(1);
		assertThat(employeBeans).extracting(EmployeBean::getEmail).containsExactly("tibarinewdzigh@gmail.com");
	}
	
	@Test
	public void findByLastNameShouldRetrieveTreeEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByLastNameContainsIgnoreCase("zer");
		assertThat(employeBeans).hasSize(3);
		assertThat(employeBeans).extracting(EmployeBean::getEmail).contains("tibarinewdzigh@gmail.com","zeroual.t@gmail.com","zeroualsouad@gmail.com");
	}
	
	@Test
	public void findByFirstNameOrLastNameOrEmailFindThree() {
		List<EmployeBean> employeBeans=employeeRepository.findByFirstNameContainsOrLastNameContainsOrEmailContainsAllIgnoreCase("sou", "ly","tiba");
		
		assertThat(employeBeans).hasSize(3);
		assertThat(employeBeans).extracting(EmployeBean::getLastName).contains("lyna","Zeroual","zeroual");
		
	}
	
	@Test
	public void findByFirstNameOrLastNameIgnoreCaseFindTwo() {
		
		List<EmployeBean> employeBeans=employeeRepository.findByFirstNameContainsOrLastNameContainsAllIgnoreCase("sou", "ly");
		assertThat(employeBeans).hasSize(2);
		assertThat(employeBeans).extracting(EmployeBean::getEmail).contains("zeroualsouad@gmail.com","lynakazzar@gmail.com");
	}
	
	@Test
	public void findByAgeRetrieveTwoEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByAgeGreaterThan(41);
		assertThat(employeBeans).hasSize(2);
		assertThat(employeBeans).extracting(EmployeBean::getFirstName).contains("Tibari","tarik");
	}
	
	@Test
	public void  findByAgeGreaterThanRetrieveOneEntry() {
		List<EmployeBean> employeBeans=employeeRepository.findByAgeGreaterThanEqual(45);
		assertThat(employeBeans).hasSize(1);
		assertThat(employeBeans).extracting(EmployeBean::getEmail).containsExactly("zeroual.t@gmail.com");
	}
	
	@Test
	public void findByAgeLessThanShouldRetrieveOneEntry() {
		List<EmployeBean> employes=employeeRepository.findByAgeLessThanEqual(20);
		assertThat(employes).hasSize(1);
		assertThat(employes).extracting(EmployeBean::getFirstName).containsExactly("kazzar");
	}

	
	@Test
	public void findByEmailIgnoreCaseShouldRetrieveOne() {
		EmployeBean employeBean=employeeRepository.findByEmailIgnoreCase("tibarinewdzign@gmail.com");
		assertThat(employeBean!=null);
		
	}
}

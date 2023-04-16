package com.arcesi.gestionemployee.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="EMPLOYES")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class EmployeBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
}

package com.example.hrms.entities.concretes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employees"})
public class Employees {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
	private int employeeId;
	
	 @Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "identitynumber")
	private String identitynumber;
	
	@Column(name = "birthofyear")
	private Date birthofyear;
	
	@Column(name = "phonenumber")
	private String phonenumber;
	

	@Column(name = "graduationstatus")
	private String graduationstatus;
	
	@Column(name = "maritalstatus")
	private String maritalstatus;
	
	@Column(name = "gender")
	private String gender;

	@Column(name = "startdate")
	private Date startdate;

	@Column(name = "dismissaldate")
	private Date dismissaldate;

	@Column(name = "unit")
	private String unit;

	@Column(name = "task")
	private String task;
	
	

	
}

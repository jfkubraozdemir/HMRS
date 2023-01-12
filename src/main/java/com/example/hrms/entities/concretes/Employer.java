package com.example.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name = "employer")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
	
	@Id
	@Column(name = "employeeid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "task")
	private String task;
	
	@Column(name = "phonenumber")
	private String phonenumber;


}

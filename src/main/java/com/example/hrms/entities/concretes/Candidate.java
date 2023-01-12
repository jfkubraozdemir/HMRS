package com.example.hrms.entities.concretes;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@Entity
@Table(name="candidate")
public class Candidate {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="candidate_id")
	private int candidateId;
	
	@Column(name = "last_name")
	private String lastName;
	
  @Column(name = "first_name")
	private String firstName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	
	@Column(name = "ıdentitynumber")
	private String ıdentitynumber;
	
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
	
}

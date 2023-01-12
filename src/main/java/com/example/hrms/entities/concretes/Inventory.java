package com.example.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ınventory")
public class Inventory {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
     @Column(name="id")
	private int id; 
	 
	 @Column(name = "ınventoryname")
		private String ınventoryname;
	 
	 @Column(name = "ınventoryentrydate")
		private Date ınventoryentrydate;
	 
	 @Column(name = "brand")
		private String brand;
	 
	 @Column(name = "model")
		private String model;
	 
	 @Column(name = "serialnumber")
		private String serialnumber;
	 
	 @Column(name = "status")
		private String status;
	
}

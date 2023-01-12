package com.example.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="possession")
public class EmployeePossession {
	 @Id
     @Column(name="id")
	private int id; 
	 
	 @Column(name = "receivingemployeeid")
		private int receivingemployeeid;
	 
	 @Column(name = "ınventoryid")
		private int ınventoryid;

	 @Column(name = "deliverydate")
		private Date deliverydate;

	 @Column(name = "DeliveryStaffID")
		private int DeliveryStaffID;


}

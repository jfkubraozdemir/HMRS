package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeerWithDto {
	private int employeeId;
     private String firstName;
     private String candidateId;
	
}

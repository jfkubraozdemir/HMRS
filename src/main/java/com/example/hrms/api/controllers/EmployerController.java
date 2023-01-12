package com.example.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployeesService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.SuccessDataResult;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.string.utilites.StringUtils;


@RestController
@RequestMapping("/api/employer")
public class EmployerController {
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService=employerService;
	}


@GetMapping("/getAll")
public DataResult<List<Employer>> getAll(){
		return  this.employerService.getAll();
}
/*
@GetMapping("/getByFullName")
public DataResult<List<Employer>> getByFullName(@RequestParam("first_name") String firstName,@RequestParam("last_name") String lastName){
	System.out.println(firstName);
	System.out.println(lastName);
	return this.employerService.getByFullName(firstName, lastName);
	
}
*/
	@GetMapping("/getByFirstName")
	public DataResult<Employer> getByFirstName(@RequestParam String firstName){
		return this.employerService.getByFirstName(firstName) ;
		
	}
	@GetMapping("/getByFirstNameContains")
	public DataResult<List<Employer>> getByFirstNameContains(@RequestParam String firstName){
	//	String replaceFirstName =StringUtils.replaceCharacter('İ','I',StringUtils.convertToUpperCase(firstName));
		return  this.employerService.getByFirstNameContains(firstName);
	}
	@GetMapping("/getByTask")
	public DataResult<List<Employer>>getByTask(String task){
		return this.employerService.getByTask(task);
	}

	@GetMapping("/getByEmployeId")
	public DataResult<List<Employer>>getByEmployeId(int employeeId){
		return this.employerService.getByEmployeId(employeeId);
	}
	
	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}
}

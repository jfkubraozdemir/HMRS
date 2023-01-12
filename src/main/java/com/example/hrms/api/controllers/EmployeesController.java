package com.example.hrms.api.controllers;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.EmployeesService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;
import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.dtos.EmployeerWithDto;
import com.example.hrms.string.utilites.StringUtils;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
private EmployeesService employeesService;

@Autowired
public EmployeesController(EmployeesService employeesService) {
	super();
	this.employeesService=employeesService;
}

@GetMapping("/getall") 
public DataResult<List<Employees>> getAll(){
	return this.employeesService.getAll();
}
//@GetMapping("/getEmployeerWithDetails") 
//public DataResult<List<EmployeerWithDto>> getEmployeerWithDetails(){
//	return this.employeesService.getEmployeerWithDetails();
//}

@GetMapping("/getAllByPage")
DataResult<List<Employees>>     getAll(int pageNo , int pageSize){
return  this.employeesService.getAll(pageNo,pageSize);
}

@PostMapping("/add")
public Result add(@RequestBody Employees employees) {
	employees.setFirstName(StringUtils.convertToUpperCase(employees.getFirstName()));
	return this.employeesService.add(employees);
}


@PostMapping("/delete")
public Result delete(@RequestParam Employees employeeId) {
	return this.employeesService.delete(employeeId);
}

@GetMapping("/getByFirstName")
public DataResult<Employees> getByFirstName(@RequestParam String firstName) throws NullPointerException{
	
	
	if (firstName!=null &&org.apache.commons.lang3.StringUtils.isNotBlank(firstName) ) {
		String replaceFirstName =StringUtils.replaceCharacter('İ','I',StringUtils.convertToUpperCase(firstName));
		return this.employeesService.getByFirstName(replaceFirstName);
	}
	else {
		 throw new NullPointerException(" Request param can't be null . " + firstName);
	}
}

//Harf olarak arama 
@GetMapping("/getByFirstNameContains")
public DataResult<List<Employees>> getByFirstNameContains(@RequestParam String firstName){

	String replaceFirstName =StringUtils.replaceCharacter('İ','I',StringUtils.convertToUpperCase(firstName));
	return this.employeesService.getByFirstNameContains(replaceFirstName);
}

@GetMapping("/getByGraduationstatus")
public DataResult<List<Employees>>getByGraduationstatus(@RequestParam String graduationstatus){
	return this.employeesService.getByGraduationstatus(graduationstatus);
}

@GetMapping("/getByBirthOfYear")
public DataResult<List<Employees>>getByBirthOfYear(@RequestParam Date birthofyear){
	return this.employeesService.getByBirthOfYear(birthofyear);
}

@GetMapping("/getByFirstNameAndEmployeeId")
public DataResult<List<Employees>> getByFirstNameAndEmployeeId(@RequestParam("first_name") String firstName,@RequestParam("employee_id") int employeeId){
	System.out.println(firstName);
	System.out.println(employeeId);
	String replaceFirstName =StringUtils.replaceCharacter('İ','I',StringUtils.convertToUpperCase(firstName));
	return this.employeesService.getByFirstNameAndEmployeeId(replaceFirstName, employeeId);


}

public EmployeesService getEmployeesService() {
	return employeesService;
}

public void setEmployeesService(EmployeesService employeesService) {
	this.employeesService = employeesService;
}
	
}

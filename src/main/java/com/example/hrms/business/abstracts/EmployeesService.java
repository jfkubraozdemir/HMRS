package com.example.hrms.business.abstracts;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.sql.Delete;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;
import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.dtos.EmployeerWithDto;




//@Transactional
public interface EmployeesService {
//	Result saveEmployees(Employees employees);
	
	//Datanın türü list of product olduğunu belirttim
	   DataResult<List<Employees>>     getAll();
	   //sayfalama:ör bir sayfada 10 data 100 ürün olan tablloda 10 sf gelicektir istenilen ürün aralığı
	   DataResult<List<Employees>>     getAll(int pageNo , int pageSize);
	   Result add(Employees employees); 
	   void deleteByEmployeeId(Employees employeeId);
	   
	   //bana datayı istediğim şarta göre sıralasın
	   DataResult<List<Employees>>     getAllSorted();
	   
	   DataResult<Employees> getByFirstName(String firstName);
//    DataResult<List<Employees>> getAll(int pageNo ,int pageSize);
//    Result add(Employees employees);
//	DataResult<Employees> getByFirstName(String firstName);
	   DataResult<List<Employees>> getByFirstNameContains(String firstName);
	   DataResult<List<Employees>>  getByFirstNameStartsWith(String firstName);
	   
	   DataResult<List<Employees>> getByGraduationstatus(String graduationstatus);
	   DataResult<List<Employees>> getByBirthOfYear(Date birthofyear);
	   
	   DataResult<List<Employees>> getByFirstNameAndEmployeeId(String firstName, int employeeId);
	Result delete(Employees employeeId);
//	DataResult<List<EmployeerWithDto>> getEmployeerWithDetails();
}


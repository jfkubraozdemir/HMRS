package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployerService {
	DataResult<List<Employer>> getByFirstNameContains(String firstName);
    DataResult<List<Employer>> getAll();
//DataResult<List<Employer>> getAll(int pageNo,int pageSize);
//Result add(Employer employer);
//void deleteByEmployer(Employer employeeId);
////DataResult<List<Employer>>     getAllSorted();
DataResult<Employer> getByFirstName(String firstName);

//DataResult<List<Employer>>  getByFirstNameStartsWith(String firstName);
//DataResult<List<Employer>>getByFullName(@RequestParam String firstName,@RequestParam String lastName);
DataResult<List<Employer>> getByEmployeId(int employeeId );
//
DataResult<List<Employer>> getByTask(String task);
}



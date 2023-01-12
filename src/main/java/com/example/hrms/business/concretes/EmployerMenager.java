package com.example.hrms.business.concretes;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.SuccessDataResult;
import com.example.hrms.dataAccess.absracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;

import net.bytebuddy.asm.Advice.This;

@Service
public class EmployerMenager implements EmployerService {
private EmployerDao employerDao;
public EmployerMenager(EmployerDao employerDao) {
	super();
	this.setEmployerDao(employerDao);
}



	@Override
	public DataResult<Employer> getByFirstName(String firstName) {
		return new SuccessDataResult<Employer>
		(this.employerDao.getByFirstName(firstName),"Data Listelendi");
	}
	
	
	@Override
	public DataResult<List<Employer>> getByFirstNameContains(String firstName) {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.getByFirstNameContains(firstName),"Data Listelendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
				(this.employerDao.findAll(),"Data Listelendi");
	}


	public EmployerDao getEmployerDao() {
		return employerDao;
	}
	public void setEmployerDao(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}



	@Override
	public DataResult<List<Employer>> getByTask(String task) {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.getByTask(task),"Task Gösterildi");
	}



	@Override
	public DataResult<List<Employer>> getByEmployeId(int employeeId) {
		
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.getByEmployeId(employeeId),"Id'den employer bulundu");
	}


//
//	@Override
//	public DataResult<List<Employer>> getByFullName(String firstName, String lastName) {
//		return new SuccessDataResult<List<Employer>>
//		(this.employerDao.getByFullName(firstName, lastName),"Data Listelendi");
//	}





}

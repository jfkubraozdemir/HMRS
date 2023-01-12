package com.example.hrms.business.concretes;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.hrms.business.abstracts.EmployeesService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;
import com.example.hrms.core.utilites.results.SuccessDataResult;
import com.example.hrms.core.utilites.results.SuccessResult;
import com.example.hrms.dataAccess.absracts.EmployeesDao;
import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.dtos.EmployeerWithDto;





@Service
public class EmployeesManager implements EmployeesService {

	         private EmployeesDao employeesDao;
	         @Autowired
	         public EmployeesManager(EmployeesDao employeesDao) {
	        	 super();
	        	 this.setEmployeesDao(employeesDao);
	         }
	
				
			
public EmployeesDao getEmployeesDao() {
				return employeesDao;
			}

public void setEmployeesDao(EmployeesDao employeesDao) {
				this.employeesDao = employeesDao;
			}



	@Override
	public DataResult<List<Employees>> getAll() {
		
		//if(1==2){return new errordataresult denebilir ve hata vermez}
		//lobal bir hata yönetimi başarılı olma durumu
		return new SuccessDataResult<List<Employees>>
		(this.employeesDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<List<Employees>> getAll(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return  new SuccessDataResult<List<Employees>>
		(this.employeesDao.findAll(pageable).getContent());
	}

	@Override
	public Result add(Employees employees) {
		this.employeesDao.save(employees);
		return new SuccessResult("Data Eklendi");
		
	}

	@Override
	public Result delete(Employees employeeId) {
		this.employeesDao.delete(employeeId);
		return new SuccessResult("Data Silindi");
	}

	@Override
	public DataResult<List<Employees>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"firstName");
		return new SuccessDataResult<List<Employees>>
		(this.employeesDao.findAll(sort),("Başarılı"));
	}

	@Override
	public DataResult<Employees> getByFirstName(String firstName) {
		return new SuccessDataResult<Employees>
		(this.employeesDao.getByFirstName(firstName),"Data Listelendi");
		
	}

    @Override
    public DataResult<List<Employees>> getByFirstNameContains(String firstName) {
	
		return new SuccessDataResult<List<Employees>>
		(this.employeesDao.getByFirstNameContains(firstName),"Data listelendi");
	}

    @Override
	public DataResult<List<Employees>> getByFirstNameStartsWith(String firstName) {
		
		return null;
	}

    @Override
	public DataResult<List<Employees>> getByGraduationstatus(String graduationstatus) {
		
		return new SuccessDataResult<List<Employees>>
		(this.employeesDao.getByGraduationstatus(graduationstatus),"Data Listelendi");
	}
   
    @Override
    public DataResult<List<Employees>> getByBirthOfYear(Date birthofyear){
	return new SuccessDataResult<List<Employees>>
	(this.employeesDao.getByBirthOfYear(birthofyear),"Data Listelendi");
}

    @Override
    public DataResult<List<Employees>> getByFirstNameAndEmployeeId(String firstName, int employeeId) {
	return new SuccessDataResult<List<Employees>>
	(this.employeesDao.getByFirstNameAndEmployeeId(firstName, employeeId),"Data Listelendi");
}



	@Override
	public void deleteByEmployeeId(Employees employeeId) {
		// TODO Auto-generated method stub
		
	}


//
//	@Override
//	public DataResult<List<EmployeerWithDto>> getEmployeerWithDetails() {
//		return new SuccessDataResult<List<EmployeerWithDto>>
//		(this.employeesDao.getEmployeerWithDetails(),"Data listelendi");
//	}



	



	





    
   


	

    
}







	






	
	



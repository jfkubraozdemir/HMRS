package com.example.hrms.dataAccess.absracts;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hrms.entities.concretes.Employees;
import com.example.hrms.entities.dtos.EmployeerWithDto;

@Repository
public interface EmployeesDao extends JpaRepository<Employees, Integer>{

	Optional<Employees> findById(Integer employeeId);
	//hangi tabloya hangi veri tipi ile bağlamılması gerektirini IRepository ile demiş oluyoruz burada
	 //bir alana göre datayı getirmek
	Employees getByFirstName(String firstName);
	 //getiBY gördüğü anda tabloya bakıyor ve ilgili where koşulunu yapıştırıyo
  
	List<Employees> getByFirstNameContains(String firstName);
//	Employees saveEmployee(Employees employees);

	@Query("From Employees where graduationstatus=:graduationstatus")
    List<Employees>  getByGraduationstatus(String graduationstatus);
//			 getByGraduationstatus(String graduationstatus);
	//select * from personelbilgileri where mezuniyetdurum = 'Önlisans'
	
//	SELECT first_name ,birthofyear  FROM employees e WHERE date_part('month',birthofyear)=8
	@Query("FROM Employees  WHERE birthofyear=:birthofyear ")
	List<Employees> getByBirthOfYear(Date birthofyear);
	
	@Query(value =  "From Employees where firstName=:firstName and employeeId=:employeeId")
	  List<Employees> getByFirstNameAndEmployeeId(String firstName, int employeeId);
	
//	@Query("Select new com.example.hrms.entities.dtos.EmployeerWithDto()"
//			+ "employeeId,firstName"
//			+ " From Employeer e ")
	//sor!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//	List<EmployeerWithDto> getEmployeerWithDetails();
//select * from Employeer e inner join 


}

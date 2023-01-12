package com.example.hrms.dataAccess.absracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




import com.example.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
Employer getByFirstName(String firstName);
List<Employer> getByFirstNameContains(String firstName);

    @Query("FROM Employer WHERE task=:task")
    List<Employer>getByTask(String task);
    
    @Query("FROM Employer where employeeId=:employeeId")
    List<Employer> getByEmployeId(int employeeId);

//
//
//@Query("FROM Employes WHERE firstName=:firstName AND  lastName=:lastName")
//List<Employer>getByFullName(String firstName,String lastName);
    
    /*
@Query("FROM Employer where employeeId=:employeeId")
List<Employer> getByEmployeId(int employeeId);


List<Employer> getByFirstNameStartsWith(String firstName);
*/
}

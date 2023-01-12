package com.example.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.core.entities.Personel;



public interface PersonelDao extends JpaRepository<Personel, Integer>{
	Personel findByEmail(String email);
               
               @Query(value="From Personel u where u.email=:email and u.password=:password")
               Personel findByUserLogin(String email, String password);
               Personel findByRole(String role);
               Personel findByUserName(String userName);
           
}

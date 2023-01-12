package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.entities.Personel;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;

public interface PersonelService {
 Result add(Personel personel);
 DataResult<Personel> findByEmail(String email);
 DataResult<Personel> findByUserLogin(String email,String passworld);
 DataResult<Personel> findByRole(String role);
 Personel findByUserName(String userName);

 
}

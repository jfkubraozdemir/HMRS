package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.PersonelService;
import com.example.hrms.core.dataAccess.PersonelDao;
import com.example.hrms.core.entities.Personel;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.Result;
import com.example.hrms.core.utilites.results.SuccessDataResult;
import com.example.hrms.core.utilites.results.SuccessResult;

import net.bytebuddy.asm.Advice.This;
@Service
public class PersonelManager implements PersonelService {
private PersonelDao personelDao;
    @Autowired
	public PersonelManager(PersonelDao personelDao) {
		super();
		this.personelDao = personelDao;
	}

	@Override
	public Result add(Personel personel) {
		this.personelDao.save(personel);
		return new SuccessResult("Kullanıcı Eklendi");
	}




	@Override
	public DataResult<Personel> findByEmail(String email) {
		
		return new SuccessDataResult<Personel>(this.personelDao.findByEmail(email)
				,"Kullanıcı Bulundu");
	}
	@Override
	public DataResult<Personel> findByUserLogin(String email, String passworld) {
		
		return new SuccessDataResult<Personel>
		(this.personelDao.findByUserLogin(email, passworld),"Kullanıcı Bulundu");
	}
	@Override
	public DataResult<Personel> findByRole(String role) {
		
		return new SuccessDataResult<Personel>
		(this.personelDao.findByRole(role),"Rol Bulundu");
	}

	@Override
	public Personel findByUserName(String userName) {
		return this.personelDao.findByUserName(userName);
	}
	

}

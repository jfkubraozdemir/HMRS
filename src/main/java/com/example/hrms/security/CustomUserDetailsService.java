package com.example.hrms.security;
import java.util.ArrayList;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hrms.business.concretes.PersonelManager;
import com.example.hrms.core.entities.Personel;
import com.example.hrms.core.utilites.results.DataResult;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	PersonelManager personelManager;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Personel personel = personelManager.findByUserName(username);
		User user=null;
		if(personel!=null) {
			user= new User(personel.getUserName(),personel.getPassword(),new ArrayList<>());
			return user;
		}
		return null;
	}
	

         
	}

	


package com.example.hrms.api.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.PersonelService;

import com.example.hrms.core.entities.Personel;

import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.core.utilites.results.ErrorDataResult;
import com.example.hrms.core.utilites.results.Result;
import com.example.hrms.entities.concretes.Employees;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

@RestController
@RequestMapping(value ="/api/users")
public class PersonelsController {
	
	private PersonelService personelService;

@Autowired
	public PersonelsController(PersonelService personelService) {
	super();
	this.personelService = personelService;
}
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Personel personel) {
		return ResponseEntity.ok(this.personelService.add(personel));
		//burada hata da dönebilir sen burada soru işaratinde ne verirsen onu döndürür
		
	}
	//AOP:yani bizim bütün methotlarımı buradan geçircek
	//bu sistemde bu tür hata olursa bunu devreye sok!!
	//tipi vercem.class ile
	//sistemde bir exception oluşursa bu metodu çağır listeye döndür ve o listeyi döndürmek hedefim
	//defauld message 
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions)
	{
		//Hangi Alanda hata oldu hata ne?
		//hata mesaj
		Map<String,String> validationErrors=new HashMap<String,String>();
	for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
		validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
	
	}
	ErrorDataResult<Object> errors
	= new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
	return errors;
	}
	
	
	@GetMapping("/findByUserLogin")
	DataResult<Personel> getByFirstNameAndEmployeeId(@RequestParam("email") String email,@RequestParam("passworld") String passworld){
		return this.personelService.findByUserLogin(email, passworld);
	}
	
	
	
	//fronted için durum  kod gerekli
    //200: get işlemi
	//300
	//400
	//500
}

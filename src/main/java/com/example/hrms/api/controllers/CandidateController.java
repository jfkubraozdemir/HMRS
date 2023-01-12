package com.example.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilites.results.DataResult;
import com.example.hrms.entities.concretes.Candidate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "Candidate")
@RestController
@RequestMapping("/api/candidate")
public class CandidateController {
private CandidateService candidateService;
@Autowired
public CandidateController(CandidateService candidateService) {
	super();
	this.candidateService=candidateService;
}


@GetMapping("/getall") 
@ApiOperation(value = "Get All Candidate")
public DataResult<List<Candidate>> getAll(){
	return this.candidateService.getAll();
}






public CandidateService getCandidateService() {
	return candidateService;
}
public void setCandidateService(CandidateService candidateService) {
	this.candidateService = candidateService;
}
}

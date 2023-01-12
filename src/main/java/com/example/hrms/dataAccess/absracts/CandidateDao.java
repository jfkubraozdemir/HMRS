package com.example.hrms.dataAccess.absracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hrms.entities.concretes.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer>{

}

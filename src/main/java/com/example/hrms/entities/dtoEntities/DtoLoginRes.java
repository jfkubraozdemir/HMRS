package com.example.hrms.entities.dtoEntities;

public class DtoLoginRes {
	private String jwt;
	private String role;
	
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}

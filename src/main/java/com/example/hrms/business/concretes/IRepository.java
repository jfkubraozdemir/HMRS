package com.example.hrms.business.concretes;

import org.aspectj.apache.bcel.util.Repository;

import com.example.hrms.entities.concretes.Employees;

public interface IRepository<T, ID> extends Repository {
	<S extends T> S save(S entity);
	void deleteByEmployeeId(Employees employeeId);
	void deleteAllById(Iterable<? extends ID> ids);
}

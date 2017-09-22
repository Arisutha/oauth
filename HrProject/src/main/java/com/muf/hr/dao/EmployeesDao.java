package com.muf.hr.dao;

import java.util.Collection;

import com.muf.hr.model.Employees;

public interface EmployeesDao {
	public boolean save(Employees employees) throws Exception;
	public boolean saveWithSP(Employees employees) throws Exception;
	public boolean update(Employees employees) throws Exception;
	public boolean delete(Employees employees) throws Exception;
	public Employees get(Employees employees) throws Exception;
	public Collection<Employees> getAllEmployees() throws Exception;
}

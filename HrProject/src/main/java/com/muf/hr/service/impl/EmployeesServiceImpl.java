package com.muf.hr.service.impl;

import java.util.Collection;

import com.muf.hr.dao.EmployeesDao;
import com.muf.hr.dao.impl.EmployeesDaoImpl;
import com.muf.hr.model.Employees;
import com.muf.hr.service.EmployeesService;

public class EmployeesServiceImpl implements EmployeesService{
	
	private EmployeesDao employeesDao = new EmployeesDaoImpl();

	@Override
	public boolean save(Employees employees) throws Exception {
		Employees tmp = this.employeesDao.get(employees);
		if(tmp != null) {
			return this.employeesDao.update(employees);
		}else{
			return this.employeesDao.save(employees);
		}
		
	}

	@Override
	public boolean saveWithSP(Employees employees) throws Exception {
		return false;
	}

	@Override
	public boolean update(Employees employees) throws Exception {
		return false;
	}

	@Override
	public boolean delete(Employees employees) throws Exception {
		return this.employeesDao.delete(employees);
	}

	@Override
	public Employees get(Employees employees) throws Exception {
		return this.employeesDao.get(employees);
	}

	@Override
	public Collection<Employees> getAllEmployees() throws Exception {
		return this.employeesDao.getAllEmployees();
	}

}

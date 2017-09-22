package com.muf.hr.service.impl;

import java.util.Collection;

import com.muf.hr.dao.DepartementsDao;
import com.muf.hr.dao.impl.DepartementsDaoImpl;
import com.muf.hr.model.Departements;
import com.muf.hr.service.DepartementsService;

public class DepartementsServiceImpl implements DepartementsService {
	
	private DepartementsDao departementsDao = new DepartementsDaoImpl();

	@Override
	public boolean save(Departements departements) throws Exception {
		return false;
	}

	@Override
	public boolean saveWithSP(Departements departements) throws Exception {
		return false;
	}

	@Override
	public boolean update(Departements departements) throws Exception {
		return false;
	}

	@Override
	public boolean delete(Departements departements) throws Exception {
		return false;
	}

	@Override
	public Departements get(Departements departements) throws Exception {
		return null;
	}

	@Override
	public Collection<Departements> getAllDepartements() throws Exception {
		return this.departementsDao.getAllDepartements();
	}

}

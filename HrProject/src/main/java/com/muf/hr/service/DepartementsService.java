package com.muf.hr.service;

import java.util.Collection;

import com.muf.hr.model.Departements;


public interface DepartementsService {
	public boolean save(Departements departements) throws Exception;
	public boolean saveWithSP(Departements departements) throws Exception;
	public boolean update(Departements departements) throws Exception;
	public boolean delete(Departements departements) throws Exception;
	public Departements get(Departements departements) throws Exception;
	public Collection<Departements> getAllDepartements() throws Exception;
}

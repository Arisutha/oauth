package com.muf.hr.service.impl;

import java.util.Collection;

import com.muf.hr.dao.JobsDao;
import com.muf.hr.dao.impl.JobsDaoImpl;
import com.muf.hr.model.Jobs;
import com.muf.hr.service.JobsService;

public class JobsServiceImpl implements JobsService {
	
	private JobsDao jobDao = new JobsDaoImpl();

	@Override
	public boolean save(Jobs jobs) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveWithSP(Jobs jobs) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Jobs jobs) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Jobs jobs) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Jobs get(Jobs jobs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Jobs> getAllJobs() throws Exception {
		return this.jobDao.getAllJobs();
	}

}

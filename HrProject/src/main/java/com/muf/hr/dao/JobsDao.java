package com.muf.hr.dao;

import java.util.Collection;

import com.muf.hr.model.Jobs;

public interface JobsDao {
	public boolean save(Jobs jobs) throws Exception;
	public boolean saveWithSP(Jobs jobs) throws Exception;
	public boolean update(Jobs jobs) throws Exception;
	public boolean delete(Jobs jobs) throws Exception;
	public Jobs get(Jobs jobs) throws Exception;
	public Collection<Jobs> getAllJobs() throws Exception;
}

package com.muf.hr.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.muf.hr.constant.sql.JobsSqlConstant;
import com.muf.hr.dao.JobsDao;
import com.muf.hr.koneksi.DbConn4;
import com.muf.hr.model.Jobs;

public class JobsDaoImpl extends DbConn4 implements JobsDao {
	
	private static final Logger logger = LoggerFactory.getLogger(JobsDaoImpl.class);

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
		Collection<Jobs> listJobs = new ArrayList<Jobs>();
		
		try {
			this.connection = this.getConnection();
			
			String sql = JobsSqlConstant.LIST_JOBS;
			this.pr = this.connection.prepareStatement(sql);
			this.rs = this.pr.executeQuery();
			
			while(this.rs.next()){
				Jobs jobs = new Jobs();
				jobs.setJobId(rs.getString("JOB_ID"));
				jobs.setJobTitle(rs.getString("JOB_TITLE"));
				jobs.setMaxSalary(rs.getBigDecimal("MAX_SALARY"));
				jobs.setMinSalary(rs.getBigDecimal("MIN_SALARY"));
				listJobs.add(jobs);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		
		return listJobs;
	}

}

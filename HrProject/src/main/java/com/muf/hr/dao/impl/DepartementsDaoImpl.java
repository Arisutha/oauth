package com.muf.hr.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.muf.hr.constant.sql.DepartementsSqlConstant;
import com.muf.hr.dao.DepartementsDao;
import com.muf.hr.koneksi.DbConn4;
import com.muf.hr.model.Departements;

public class DepartementsDaoImpl extends DbConn4 implements DepartementsDao {

	private static final Logger logger = LoggerFactory.getLogger(DepartementsDaoImpl.class);

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
		Collection<Departements> listJobs = new ArrayList<Departements>();

		try {
			this.connection = this.getConnection();

			String sql = DepartementsSqlConstant.LIST_DEPARTEMENTS;
			this.pr = this.connection.prepareStatement(sql);
			this.rs = this.pr.executeQuery();

			while (this.rs.next()) {
				Departements departements = new Departements();
				departements.setDepartementId(this.rs.getInt("DEPARTMENT_ID"));
				departements.setDepartementName(this.rs.getString("DEPARTMENT_NAME"));
				departements.setManagerId(this.rs.getInt("MANAGER_ID"));
				departements.setLocationId(this.rs.getInt("LOCATION_ID"));
				listJobs.add(departements);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			this.closeConnection();
		}

		return listJobs;
	}

}

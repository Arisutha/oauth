/**
 * 
 */
package com.muf.hr.dao.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.muf.hr.constant.sql.EmployeeSqlConstant;
import com.muf.hr.dao.EmployeesDao;
import com.muf.hr.koneksi.DbConn4;
import com.muf.hr.model.Employees;

/**
 * @author 15997049
 *
 */
public class EmployeesDaoImpl extends DbConn4 implements EmployeesDao {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeesDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#save(com.muf.hr.model.Employees)
	 */
	@Override
	public boolean save(Employees employees) throws Exception {
		try {
			this.connection = this.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = EmployeeSqlConstant.INSERT_EMPLOYEES;			
			this.pr = this.connection.prepareStatement(sql);
			
			this.pr.setInt(1, employees.getEmployeeId());
			this.pr.setString(2, employees.getFirstName());
			this.pr.setString(3, employees.getLastName());
			this.pr.setString(4, employees.getEmail());
			this.pr.setString(5, employees.getPhoneNumber());
			this.pr.setDate(6, employees.getHireDate());
			this.pr.setString(7, employees.getJobsId());
			this.pr.setBigDecimal(8, employees.getSalary());
			this.pr.setObject(9, employees.getCommissionPct());
			this.pr.setObject(10, employees.getManagerId());
			this.pr.setObject(11, employees.getDepartementId());
			
			this.pr.execute();
			this.connection.commit();
			this.isNoError = true;
		} catch (Exception e) {
			this.isNoError = false;
			this.connection.rollback();
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		
		return this.isNoError;
	}

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#saveWithSP(com.muf.hr.model.Employees)
	 */
	@Override
	public boolean saveWithSP(Employees employees) throws Exception {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#update(com.muf.hr.model.Employees)
	 */
	@Override
	public boolean update(Employees employees) throws Exception {
		try {
			this.connection = this.getConnection();
			this.connection.setAutoCommit(false);
			
			String sql = EmployeeSqlConstant.UPDATE_EMPLOYEES;			
			this.pr = this.connection.prepareStatement(sql);
			
			this.pr.setString(1, employees.getFirstName());
			this.pr.setString(2, employees.getLastName());
			this.pr.setString(3, employees.getEmail());
			this.pr.setString(4, employees.getPhoneNumber());
			this.pr.setDate(5, employees.getHireDate());
			this.pr.setString(6, employees.getJobsId());
			this.pr.setBigDecimal(7, employees.getSalary());
			this.pr.setObject(8, employees.getCommissionPct());
			this.pr.setObject(9, employees.getManagerId());
			this.pr.setObject(10, employees.getDepartementId());
			this.pr.setInt(11, employees.getEmployeeId());
			
			this.pr.execute();
			this.connection.commit();
			this.isNoError = true;
		} catch (Exception e) {
			e.printStackTrace();
			this.isNoError = false;
			this.connection.rollback();
			logger.error(e.getMessage(), e);
			logger.error(ExceptionUtils.getRootCauseMessage(e));
		}finally {
			this.closeConnection();
		}
		
		return this.isNoError;
	}

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#delete(com.muf.hr.model.Employees)
	 */
	@Override
	public boolean delete(Employees employees) throws Exception {
		try {
			this.connection = this.getConnection();
			this.connection.setAutoCommit(false);
			String sql = EmployeeSqlConstant.DELETE_EMPLOYEES_BY_EMPLOYEEID;
			this.pr = this.connection.prepareStatement(sql);
			this.pr.setInt(1, employees.getEmployeeId());
			this.pr.execute();
			this.connection.commit();
			this.isNoError = true;
		} catch (Exception e) {
			this.connection.rollback();
			this.isNoError = false;
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		return this.isNoError;
	}

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#get(com.muf.hr.model.Employees)
	 */
	@Override
	public Employees get(Employees employees) throws Exception {
		Employees tmp = null;
		try {
			this.connection = this.getConnection();
			
			String sql = EmployeeSqlConstant.GET_EMPLOYEES_BY_EMPLOYEEID;
			this.pr = this.connection.prepareStatement(sql);
			this.pr.setInt(1, employees.getEmployeeId());
			this.rs = this.pr.executeQuery();
			
			if(this.rs.next()){
				tmp = new Employees();
				tmp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				tmp.setFirstName(rs.getString("FIRST_NAME"));
				tmp.setLastName(rs.getString("LAST_NAME"));
				tmp.setEmail(rs.getString("EMAIL"));
				tmp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				tmp.setHireDate(rs.getDate("HIRE_DATE"));
				tmp.setJobsId(rs.getString("JOB_ID"));
				tmp.setSalary(rs.getBigDecimal("SALARY"));
				tmp.setCommissionPct(rs.getInt("COMMISSION_PCT"));
				tmp.setManagerId(rs.getInt("MANAGER_ID"));
				tmp.setDepartementId(rs.getInt("DEPARTMENT_ID"));
			}
		} /*catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}*/catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		return tmp;
	}

	/* (non-Javadoc)
	 * @see com.muf.hr.dao.EmployeesDao#getAllEmployees()
	 */
	@Override
	public Collection<Employees> getAllEmployees() throws Exception {
		Collection<Employees> listEmployees = new ArrayList<Employees>();
		
		try {
			this.connection = this.getConnection();
			
			String sql = EmployeeSqlConstant.LIST_EMPLOYEES;
			this.pr = this.connection.prepareStatement(sql);
			this.rs = this.pr.executeQuery();
			
			while(this.rs.next()){
				Employees employees = new Employees();
				employees.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employees.setFirstName(rs.getString("FIRST_NAME"));
				employees.setLastName(rs.getString("LAST_NAME"));
				employees.setEmail(rs.getString("EMAIL"));
				employees.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				employees.setHireDate(rs.getDate("HIRE_DATE"));
				employees.setJobsId(rs.getString("JOB_ID"));
				employees.setSalary(rs.getBigDecimal("SALARY"));
				employees.setCommissionPct(rs.getInt("COMMISSION_PCT"));
				employees.setManagerId(rs.getInt("MANAGER_ID"));
				employees.setDepartementId(rs.getInt("DEPARTMENT_ID"));
				
				listEmployees.add(employees);
			}
		} /*catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		}*/catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		
		return listEmployees;
	}

}

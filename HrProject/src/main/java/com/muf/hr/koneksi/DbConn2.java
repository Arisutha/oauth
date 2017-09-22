/**
 * 
 */
package com.muf.hr.koneksi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * @author 15997049
 * JNDI For Oracle
 */
public class DbConn2 {
	
	protected PreparedStatement pr = null;
	protected ResultSet rs = null;
	protected CallableStatement cl = null;
	protected Connection connection = null;
	protected boolean isNoError = false;
	
	public Connection getConnection() {
		DataSource dataSource = null;
		InitialContext ic;
		Connection con = null;
		
		try {
			ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:/oracleHr");
			con = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
	
	public void closeConnection(){
		try {
			if(connection != null){
				connection.close();
			}
			
			if(pr != null){
				pr.close();
			}
			
			if(rs != null){
				rs.close();
			}
			
			if(cl != null){
				cl.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

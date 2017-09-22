package com.muf.hr.koneksi;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConn4 {
	protected PreparedStatement pr = null;
	protected ResultSet rs = null;
	protected CallableStatement cl = null;
	protected Connection connection = null;
	protected boolean isNoError = false;
	
	private String url;
	private String username;
	private String password;
	private String driver;
	
	public DbConn4(){
		this.url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		this.username="hr";
		this.password="admin";
		this.driver="oracle.jdbc.driver.OracleDriver";
	}
	
	public void connect(){
		try {
			Class.forName(this.driver);
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		try {
			if(this.connection == null)
				this.connect();
			else if(this.connection.isClosed())
				this.connect();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return this.connection;
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
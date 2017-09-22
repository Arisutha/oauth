package com.muf.hr.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.muf.hr.constant.sql.UserSqlConstant;
import com.muf.hr.dao.UserDao;
import com.muf.hr.koneksi.DbConn4;
import com.muf.hr.model.User;

import java.util.Collection;

/**
 * Created by sutaeni on 4/23/2016.
 */
public class UserDaoImpl  extends DbConn4 implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	public User getUserByUserId(String param) throws Exception {
		return null;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		return null;
	}

	@Override
	public User getUserByUserByEmail(String param) throws Exception {
		User tmp = null;
		try {
			this.connection = this.getConnection();
			
			String sql = UserSqlConstant.GET_USER_BY_USERNAME;
			this.pr = this.connection.prepareStatement(sql);
			this.pr.setString(1, param);
			this.rs = this.pr.executeQuery();
			
			if(this.rs.next()){
				tmp = new User();
				tmp.setId(this.rs.getLong("USID"));
				tmp.setAccountExpiredDate(this.rs.getDate("USACCEXPDATE"));
				tmp.setUsername(this.rs.getString("USNAME"));
				tmp.setUserId(this.rs.getString("USUSERID"));
				tmp.setEnabled(this.rs.getBoolean("USENABLED"));
				tmp.setPassword(this.rs.getString("USPASSWORD"));
				tmp.setEmail(this.rs.getString("USEMAIL"));
				tmp.setCredentialsNonExpired(this.rs.getBoolean("USCRENONEXP"));
				tmp.setCredentialExpiredDate(this.rs.getDate("USCREEXPDATE"));
				tmp.setAccountNonLocked(this.rs.getBoolean("USACCNONLOC"));
				tmp.setAccountNonExpired(this.rs.getBoolean("USACCNONEXP"));
				tmp.setAccountExpiredDate(this.rs.getDate("USACCEXPDATE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}finally {
			this.closeConnection();
		}
		return tmp;
	}

	@Override
	public Collection<User> listSuperUser() throws Exception {
		return null;
	}

	@Override
	public void updateLastLogin(User user) throws Exception {
		
	}
}
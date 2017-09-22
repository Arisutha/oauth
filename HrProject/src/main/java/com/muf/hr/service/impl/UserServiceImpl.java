package com.muf.hr.service.impl;

import com.muf.hr.dao.UserDao;
import com.muf.hr.dao.impl.UserDaoImpl;
import com.muf.hr.model.User;
import com.muf.hr.service.UserService;

import java.util.Collection;

/**
 * Created by sutaeni on 4/23/2016.
 */
public class UserServiceImpl implements UserService {
	
    private UserDao userDao = new UserDaoImpl();;

    @Override
    public User getUserByUserId(String param) throws Exception {
        return this.userDao.getUserByUserId(param);
    }

    @Override
    public User getUserByUserByEmail(String param) throws Exception {
        return this.userDao.getUserByUserByEmail(param);
    }

    @Override
    public Collection<User> listSuperUser() throws Exception {
        return this.userDao.listSuperUser();
    }

	@Override
	public void updateLastLogin(User user) throws Exception {
		User temp = this.userDao.getUserById(user.getId());
		if(temp != null){
			temp.setLastLogon(user.getLastLogon());
			this.userDao.updateLastLogin(temp);
		}
	}
}

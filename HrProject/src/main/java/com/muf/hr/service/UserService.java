package com.muf.hr.service;

import java.util.Collection;

import com.muf.hr.model.User;


/**
 * Created by sutaeni on 4/23/2016.
 */
public interface UserService {
    public User getUserByUserId(String param) throws Exception;
    public User getUserByUserByEmail(String param) throws Exception;
    public Collection<User> listSuperUser() throws Exception;
    public void updateLastLogin(User user) throws Exception;
}

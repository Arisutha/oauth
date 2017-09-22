package com.muf.hr.dao;


import java.util.Collection;

import com.muf.hr.model.User;

public interface UserDao {
    public User getUserByUserId(String param) throws Exception;
    public User getUserById(Long id) throws Exception;
    public User getUserByUserByEmail(String param) throws Exception;
    public Collection<User> listSuperUser() throws Exception;
    public void updateLastLogin(User user) throws Exception;
}

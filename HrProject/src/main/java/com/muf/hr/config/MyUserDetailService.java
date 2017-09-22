package com.muf.hr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.muf.hr.model.User;
import com.muf.hr.service.UserService;
import com.muf.hr.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sutaeni on 4/23/2016.
 */
public class MyUserDetailService implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(MyUserDetailService.class);
	private UserService userService = new UserServiceImpl();

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		log.debug("load user by username");
		User user = null;
		UserDetails details = null;
		boolean loadByEmail = false;
		try {
			log.debug("get user by user Id");
			user = this.userService.getUserByUserByEmail(userId);
			loadByEmail = (user != null) ? true : false;
			if (user != null) {
				Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				// role masih hardcode
				GrantedAuthority ga = new MyGrantAuthority(1L, "ROLE_ADMIN", "");
				authorities.add(ga);
				details = new MyUserDetails(authorities, user, loadByEmail);
				return details;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return details;
	}

	@Autowired
	@Qualifier("userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

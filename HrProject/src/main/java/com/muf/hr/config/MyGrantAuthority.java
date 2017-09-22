package com.muf.hr.config;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by sutaeni on 4/23/2016.
 */
public class MyGrantAuthority implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String authority;
    private String permissionName;

    public MyGrantAuthority(Long id, String authority, String permissionName){
        this.authority = authority;
        this.id = id;
        this.permissionName = permissionName;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
    
    public Long getId() {
		return this.id;
	}
    
    public String getPermissionName() {
		return permissionName;
	}
}

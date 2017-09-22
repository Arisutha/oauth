package com.muf.hr.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.muf.hr.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
 * Created by sutaeni on 4/23/2016.
 */
public class MyUserDetails implements UserDetails {
	private static final long serialVersionUID = 1272393617921290855L;
	private Collection<GrantedAuthority> authorities = null;
    private String username = null;
    private String userid = null;
    private String password = null;
    private String additionalData = null;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private User user = null;
    private Date lastLogon = null;
    private boolean loadByEmail = false;

    public MyUserDetails(Collection<GrantedAuthority> authorities, User user, boolean loadByEmail) {
        this.authorities = authorities;
        this.user = user;

        Calendar today = Calendar.getInstance();
        Calendar accExpDate = Calendar.getInstance();
        Calendar credExpDate = Calendar.getInstance();

        if(user.getAccountNonExpired() != null && user.getAccountNonExpired()){
            accExpDate.setTime(user.getAccountExpiredDate());
        }
        if(user.getCredentialsNonExpired() != null && user.getCredentialsNonExpired()){
            credExpDate.setTime(user.getCredentialExpiredDate());
        }

        this.password = user.getPassword();
        this.username = user.getUsername();
        this.loadByEmail = loadByEmail;
        if(loadByEmail) this.userid = user.getEmail();
        else this.userid = user.getUserId();

        this.enabled = user.getEnabled();
        this.accountNonExpired = (accExpDate.getTimeInMillis() >= today.getTimeInMillis());
        this.accountNonLocked = user.getAccountNonLocked();
        this.credentialsNonExpired = (credExpDate.getTimeInMillis() >= today.getTimeInMillis());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
    public void setLastLogon(Date date) {
		this.lastLogon = date;
	}

	public String getLastLogonString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		return ((this.lastLogon != null) ? sdf.format(this.lastLogon) : "");
	}

	public boolean isLoadByEmail() {
		return loadByEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getAdditionalData() {
		return this.additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}
}
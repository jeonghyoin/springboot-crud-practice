package com.example.demo.board.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Member implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private Collection<? extends GrantedAuthority> authorities;
    
    private int loginFailCnt;
    private int progressStatus;
    private String authority;
    
    public int getLoginFailCnt() {
		return loginFailCnt;
	}
	public void setLoginFailCnt(int loginFailCnt) {
		this.loginFailCnt = loginFailCnt;
	}

	public int getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(int progressStatus) {
		this.progressStatus = progressStatus;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
 
    public void setAccountNonExpired(boolean isAccountNonExpired) {
        this.isAccountNonExpired = isAccountNonExpired;
    }
 
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
    public void setAccountNonLocked(boolean isAccountNonLocked) {
        this.isAccountNonLocked = isAccountNonLocked;
    }
 
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
 
    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
        this.isCredentialsNonExpired = isCredentialsNonExpired;
    }
 
    public boolean isEnabled() {
        return isEnabled;
    }
 
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
 
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
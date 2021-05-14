package com.used.example.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserInfo {
	
	private static final long serialVersionUID =1L;
	private String username;//이메일
	private String name;
	private String phone;
	private String address;
	private Collection<? extends GrantedAuthority> authorities;
	private String auth;
	private int u_num;
	private String password;
	private List<Object> roles;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(auth);
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Object> getRoles() {
		return roles;
	}
	public void setRoles(List<Object> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", authorities=" + authorities + ", auth=" + auth + ", u_num=" + u_num + ", password=" + password
				+ ", roles=" + roles + "]";
	}
	
	
	
	
	
	
	
	
	

}

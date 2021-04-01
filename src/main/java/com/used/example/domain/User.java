package com.used.example.domain;



import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private String username;//email
	private String password;
	private String phone;
	private String numStr;
	private String name;//별명
	private String address;
	private Collection<? extends GrantedAuthority> authorities;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	
	
	
	
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    @Override
	public String getPassword() {
		return password;
	}
    
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities= authorities;
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}
	public void setisAccountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired= isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	public void setisAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked= isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	public void setisCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired= isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setisEnabled(boolean isEnabled) {
		this.isEnabled= isEnabled;
	}
	public String getNumStr() {
		return numStr;
	}

	public void setNumStr(String numStr) {
		this.numStr = numStr;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", numStr=" + numStr
				+ ", name=" + name + ", address=" + address + ", authorities=" + authorities + ", isAccountNonExpired="
				+ isAccountNonExpired + ", isAccountNonLocked=" + isAccountNonLocked + ", isCredentialsNonExpired="
				+ isCredentialsNonExpired + ", isEnabled=" + isEnabled + "]";
	}
	
	
	
}

	
	
	
	
	
	

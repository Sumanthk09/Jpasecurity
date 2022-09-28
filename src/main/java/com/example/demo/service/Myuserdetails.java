package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.Dbsuser;

public class Myuserdetails implements UserDetails
{
	String username;
	String password;
	List<GrantedAuthority> rolesl=new ArrayList<GrantedAuthority>();
	
	public Myuserdetails(Dbsuser dbsuser)
	{
		this.username=dbsuser.getUsername();
		this.password=dbsuser.getPassword();
		String roles[]=dbsuser.getRoles().split(",");
		for(int i=0;i<roles.length;i++)
			this.rolesl.add(new SimpleGrantedAuthority(roles[i]));
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.rolesl;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

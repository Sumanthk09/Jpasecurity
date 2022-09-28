package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Dbsuser;
import com.example.demo.repo.Dbsuserrepo;
@Service
public class Dbsdetailservice implements UserDetailsService
{
	@Autowired
	Dbsuserrepo dr;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Dbsuser dbsuser=dr.findByUsername(username);
		Myuserdetails ur=new Myuserdetails(dbsuser);
		return ur;	
	}
}

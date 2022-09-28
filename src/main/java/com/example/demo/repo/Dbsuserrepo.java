package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Dbsuser;

public interface Dbsuserrepo extends JpaRepository<Dbsuser, Integer>
{
	public Dbsuser findByUsername(String username);
}

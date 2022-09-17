package com.example.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByName(String name);
}

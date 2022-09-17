package com.example.test.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.User;
import com.example.test.repository.UserRepository;

@Service
public class UserService {

	private final static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		logger.info("we found your list" + userRepository.findAll() );
		return userRepository.findAll();
	}

	public void deleteById(Long Id) {
		User user = userRepository.findById(Id).orElseThrow(
				() -> new IllegalArgumentException("Invalid user Id:" + Id));
		userRepository.delete(user);
	}
	
	public User findById(Long id) {
		
		return userRepository.findById(id).orElseThrow(() -> 
		new IllegalArgumentException("invlaid id" + id));
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

}

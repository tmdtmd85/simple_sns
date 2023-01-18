package com.example.securingweb;

import org.springframework.data.repository.CrudRepository;

import com.example.securingweb.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}

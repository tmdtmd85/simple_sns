package com.example.securingweb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisteringRepository extends JpaRepository<Registering, Integer> {
	Optional<Registering> findByTeloremail(String teloremail);
}


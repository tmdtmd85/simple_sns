package com.mysite.sbb.user;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisteringService {
	private final RegisteringRepository registeringRepository;
	private final PasswordEncoder passwordEncoder;
	
	public Registering create(String surname, 
			String name,
			String username,
			String password,
			String year,
			String month,
			String day,
			String gender) {
		  Registering n = new Registering();
		  n.setSurname(surname);
		  n.setName(name);
		  n.setUsername(username);
		  n.setPassword(passwordEncoder.encode(password));
		  n.setYear(year);
		  n.setMonth(month);
		  n.setDay(day);
		  n.setGender(gender);
		  this.registeringRepository.save(n);
		  return n;
	}
}

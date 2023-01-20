package com.mysite.sbb.user.database.registering;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	
	public void changeBackground(Integer id, String backgroundpath) {
		this.registeringRepository.changeBackground(id, backgroundpath);
	}
	
	public void changeProfile(Integer id, String profilepath) {
		this.registeringRepository.changeProfile(id, profilepath);
	}
}

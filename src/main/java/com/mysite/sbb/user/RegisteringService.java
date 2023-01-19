package com.mysite.sbb.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisteringService {
	private final RegisteringRepository registeringRepository;
	
	public Registering create(String surname, 
			String name,
			String teloremail,
			String password,
			String year,
			String month,
			String day,
			String gender) {
		  Registering n = new Registering();
		  n.setSurname(surname);
		  n.setName(name);
		  n.setTeloremail(teloremail);
		  n.setPassword(password);
		  n.setYear(year);
		  n.setMonth(month);
		  n.setDay(day);
		  n.setGender(gender);
		  this.registeringRepository.save(n);
		  return n;
	}
}

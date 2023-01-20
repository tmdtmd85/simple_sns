package com.mysite.sbb.user.database.registering;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registering {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String surname;
	private String name;
	private String username;
	private String password;
	private String year;
	private String month;
	private String day;
	private String gender;
	private String profile = "./common/profile.jpg";
	private String background = "./common/background.jfif";

}
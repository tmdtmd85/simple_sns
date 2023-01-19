package com.example.securingweb;

import lombok.Getter;

@Getter
public enum RegisteringRole {
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	RegisteringRole(String value) {
		this.value = value;
	}
	
	private String value;
}

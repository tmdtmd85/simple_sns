package com.mysite.sbb.user.database.registering;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class RegisteringAdapter extends User implements Serializable {
	private Registering registering;
	
	public RegisteringAdapter(Registering registering, Collection<? extends GrantedAuthority> authorities) {
		super(registering.getUsername(), registering.getPassword(), authorities);
		this.registering = registering;
	}
}

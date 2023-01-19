package com.example.securingweb;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisteringSecurityService implements UserDetailsService {
    private final RegisteringRepository registeringRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	/*
        Optional<Registering> _registering = this.registeringRepository.findByTeloremail(username);
        if (_registering.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
        }
        Registering registering = _registering.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("admin".equals(username)) {
            authorities.add(new SimpleGrantedAuthority(RegisteringRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(RegisteringRole.USER.getValue()));
        }
        */
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(RegisteringRole.USER.getValue()));
        return new User(
	    	"abc",
	    	"123",
	    	authorities);
    }
}

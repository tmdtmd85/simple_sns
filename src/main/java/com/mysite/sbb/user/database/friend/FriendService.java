package com.mysite.sbb.user.database.friend;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FriendService {
	private final FriendRepository friendRepository;
	
	public Friend create(Integer sendid, 
			Integer destid
		) {
		  Friend f = new Friend();
		  f.setSendid(sendid);
		  f.setDestid(destid);
		  this.friendRepository.save(f);
		  return f;
	}
	
	public void approval(Integer sendid, Integer destid) {
		this.friendRepository.approval(sendid, destid);
	}
}

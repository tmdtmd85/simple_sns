package com.mysite.sbb.user;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	private final CommentRepository commentRepository;
	
	public Comment create(Integer userid,
			String comment,
			String imagepath
			) {
		  Comment c = new Comment();
		  c.setUserid(userid);
		  c.setComment(comment);
		  c.setImagepath(imagepath);
		  this.commentRepository.save(c);
		  return c;
	}
}

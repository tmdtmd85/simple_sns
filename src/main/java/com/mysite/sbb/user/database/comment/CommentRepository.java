package com.mysite.sbb.user.database.comment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	List<Comment> findByUserid(Integer id);
}


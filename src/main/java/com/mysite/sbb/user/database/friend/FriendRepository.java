package com.mysite.sbb.user.database.friend;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.user.database.comment.Comment;

public interface FriendRepository extends JpaRepository<Friend, Long>{
	@Transactional
	@Modifying // select 문이 아님을 나타낸다
	@Query(value = "UPDATE Friend f set f.approval = 1 where f.sendid = :sendid and f.destid = :destid", nativeQuery = true)
	void approval(@Param("sendid")Integer sendid, @Param("destid")Integer destid);
	List<Friend> findByDestidAndApproval(Integer destid, Boolean approval);
}

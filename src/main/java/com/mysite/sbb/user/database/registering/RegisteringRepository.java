package com.mysite.sbb.user.database.registering;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RegisteringRepository extends JpaRepository<Registering, Long>{
	Optional<Registering> findByusername(String username);
	
	@Transactional
	@Modifying // select 문이 아님을 나타낸다
	@Query(value = "UPDATE Registering r set r.background = :background where r.id = :id", nativeQuery = true)
	void changeBackground(@Param("id")Integer id, @Param("background")String backgroundpath);
	
	@Transactional
	@Modifying // select 문이 아님을 나타낸다
	@Query(value = "UPDATE Registering r set r.profile = :profile where r.id = :id", nativeQuery = true)
	void changeProfile(@Param("id")Integer id, @Param("profile")String profilepath);
}

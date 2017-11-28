package com.navnbp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.navnbp.entity.UserDetail;


@Component
public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
	
	public Optional<UserDetail> findByUserName(String login);
}

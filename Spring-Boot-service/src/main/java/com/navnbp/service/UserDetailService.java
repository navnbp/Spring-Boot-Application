package com.navnbp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.navnbp.entity.UserDetail;

@Service
public interface UserDetailService {

	String validateUser(String userName, String password);

	void addLogin(UserDetail login);

	List<UserDetail> findAll();

	Optional<UserDetail> findByUserName(String userName);

	void delete();

}

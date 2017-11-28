package com.navnbp.service;

import org.springframework.stereotype.Service;

import com.navnbp.entity.UserDetail;

@Service
public interface UserDetailService {

	public UserDetail test() ;
	public String validate(UserDetail login ) ;
	
}

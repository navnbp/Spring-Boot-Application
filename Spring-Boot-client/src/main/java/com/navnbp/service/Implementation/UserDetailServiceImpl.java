package com.navnbp.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.navnbp.config.RestServiceCall;
import com.navnbp.entity.UserDetail;
import com.navnbp.service.UserDetailService;

@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private RestServiceCall restServiceCall;
	
	
	
	public UserDetail test() 
	{
	
		ResponseEntity<UserDetail[]>response = restServiceCall.execute("/login/all", HttpMethod.GET, null, UserDetail[].class);
	//	Login[] response =	restOperations.getForObject(url+"/login/all", Login[].class);
		System.out.println(response.getBody().length);
		
		return response.getBody()[0];
	}

	@Override
	public String validate(final UserDetail login) {
		
		
		ResponseEntity<String> result= restServiceCall.execute("/login/validate", HttpMethod.POST,login,String.class);
		return result.getBody();
	}
	
}

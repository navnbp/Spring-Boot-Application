package com.navnbp.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navnbp.entity.UserDetail;
import com.navnbp.repository.UserDetailRepository;
import com.navnbp.service.UserDetailService;


@Service
public class UserDetailServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository loginRepository;

	@Override
	public String validateUser(String userName, String password)  {

		Optional<UserDetail> loginDetails = loginRepository.findByUserName(userName);

		if (loginDetails.isPresent()) {
			if (loginDetails.get().getPassword().equals(password))
				return "SUCCESS";
			else
				return "Wrong Password";
		} else {
				return "User Not Present";
			
		}

	}

	@Override
	public void addLogin(UserDetail login) {
		loginRepository.save(login);

	}
	
	@Override
	public void delete() 
	{
		loginRepository.deleteAll();
		
	}

	@Override
	public List<UserDetail> findAll() {
		return loginRepository.findAll();

	}

	@Override
	public Optional<UserDetail> findByUserName(String userName) {
	
		return loginRepository.findByUserName(userName);
	}

}

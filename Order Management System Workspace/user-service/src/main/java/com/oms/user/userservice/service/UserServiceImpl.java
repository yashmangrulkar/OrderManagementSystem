package com.oms.user.userservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oms.user.userservice.model.User;
import com.oms.user.userservice.repository.UserLoginRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserLoginRepository userLoginRepository;

	@Override
	public User userLogin(String username, String password) {

		LOGGER.info("Start UserLogin Method");
		LOGGER.info(" Username provided is : " + username);
		LOGGER.info(" Password provided is : " + password);

		List<User> userList = null;
		try {
			userList = userLoginRepository.findAllByUsernameAndPassword(username, password);
		} catch (Exception e) {
			LOGGER.error("Error While Fetching UserLogin Method: " + e.getMessage());
		}
		LOGGER.info("End UserLogin Method");
		return userList.get(0);
	}

}

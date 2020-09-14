package com.oms.user.userservice.service;

import com.oms.user.userservice.model.User;

public interface UserService {

	public User userLogin(String username, String password);

}

package com.oms.user.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oms.user.userservice.model.User;

public interface UserLoginRepository extends JpaRepository<User, Integer> {

	public List<User> findAllByUsernameAndPassword(String username, String password);

}

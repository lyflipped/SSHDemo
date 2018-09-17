package com.ssh.service;

import java.util.List;

import com.ssh.entity.User;

public interface UserService {
	public User findUserByName(String username) throws Exception;
	public User findUserById(Integer id) throws Exception;
	public List<User> findUserList() throws Exception;
	public void insertUser(User user) throws Exception;
	public void deleteUser(Integer id) throws Exception;
	public void updateUserName(User user) throws Exception;
}

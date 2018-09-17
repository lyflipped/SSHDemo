package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.entity.User;
import com.ssh.service.UserService;
@Service("userServiceImpl")
@Transactional
public class UserServiceImpl implements UserService{
	@Resource(name = "userDaoImpl")
	UserDao userDao;
	
	@Override
	public User findUserByName(String username) throws Exception {
		return userDao.findUserByName(username);
	}

	@Override
	public User findUserById(Integer id) throws Exception {
		
		return userDao.findUserById(id);
	}

	@Override
	public List<User> findUserList() throws Exception {
	
		return userDao.findUserList();
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserName(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

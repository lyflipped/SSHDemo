package com.ssh.dao;

import java.util.List;


import com.ssh.entity.User;

/**
 * mapper的动态代理(该代理的配置xml文件必须和这个接口放在同一个包下，且名称完全一样)
 * @author liyang
 *
 */
public interface UserDao {
	
	public User findUserById(Integer id) throws Exception;
	public List<User> findUserList() throws Exception;
	public void insertUser(User user) throws Exception;
	public void deleteUser(Integer id) throws Exception;
	public void updateUserName(User user) throws Exception;
}

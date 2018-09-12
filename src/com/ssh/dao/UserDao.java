package com.ssh.dao;

import java.util.List;


import com.ssh.entity.User;

/**
 * mapper�Ķ�̬����(�ô��������xml�ļ����������ӿڷ���ͬһ�����£���������ȫһ��)
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

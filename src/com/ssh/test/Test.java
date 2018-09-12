package com.ssh.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.entity.User;
import com.ssh.service.UserService;
import com.sun.xml.internal.bind.CycleRecoverable.Context;

public class Test {
	private static ApplicationContext applicationContext=null;
	private static UserService userService = null;
	static{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		userService = applicationContext.getBean(UserService.class);
	}
	public static void main(String[] args){
		User user;
		try {
			user = userService.findUserById(4);
			System.out.println(user);
			List<User> users = userService.findUserList();
			System.out.println(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	  
	 
}

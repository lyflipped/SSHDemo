package com.ssh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.entity.User;
import com.ssh.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Resource(name = "userServiceImpl")
	UserService userService;
	
	@RequestMapping("login")
	public ModelAndView login(User user){
		ModelAndView mv = new ModelAndView();
		String result = "初始值";
		String method = "login";
		try {
			User ans = userService.findUserByName(user.getUsername());
			if(ans==null){
				result = "fail,用户名错误";
			}
			else if(ans.getPassword().equals(user.getPassword())){
				result = "success";
			}else{
				result = "fail,密码错误！";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = "insert fail";
			e.printStackTrace();
		}
		mv.addObject("method", method);
		mv.addObject("result", result);
		mv.setViewName("/result");
		return mv;
	}
	@RequestMapping("getUserById")
	public ModelAndView getUserById(@RequestParam(value="id",defaultValue="1") Integer id){
		ModelAndView mv = new ModelAndView();
		try {
			User user = userService.findUserById(id);
			List<User> list =new ArrayList<>();
			list.add(user);
			mv.addObject(list);
			mv.setViewName("/show");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("insertUser")
	public ModelAndView insertUser(User user){
		ModelAndView mv = new ModelAndView();
		String result = "初始值";
		String method = "insert";
		try {
			userService.insertUser(user);
			result = "insert success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = "insert fail";
			e.printStackTrace();
		}
		mv.addObject("method", method);
		mv.addObject("result", result);
		mv.setViewName("/result");
		return mv;
	}
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(Integer id){
		ModelAndView mv = new ModelAndView();
		String result = "初始值";
		String method = "delete";
		try {
			userService.deleteUser(id);;
			result = "delete success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = "delete fail";
			e.printStackTrace();
		}
		mv.addObject("method", method);
		mv.addObject("result", result);
		mv.setViewName("/result");
		return mv;
	}
	@RequestMapping("getUserList")
	public ModelAndView getUserList(){
		ModelAndView mv = new ModelAndView();
		try {
			List<User> list = userService.findUserList();
			mv.addObject(list);
			mv.setViewName("/show");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	@RequestMapping("updateUserName")
	public ModelAndView updateUserName(User user){
		ModelAndView mv = new ModelAndView();
		String result = "初始值";
		String method = "updateUserName";
		try {
			userService.updateUserName(user);
			result = "update success";
			
		} catch (Exception e) {
			result = "update fail";
			e.printStackTrace();
		}
		mv.addObject("method", method);
		mv.addObject("result", result);
		mv.setViewName("/result");
		return mv;
	}
	@RequestMapping("testJson")
	@ResponseBody
	public User getUser(){
		User user = new User();
		try {
			user = userService.findUserById(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}

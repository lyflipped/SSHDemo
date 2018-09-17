package com.ssh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssh.entity.User;
import com.ssh.service.UserService;

@Controller
@RequestMapping("/common/")
public class LoginController {
	@Resource(name = "userServiceImpl")
	UserService userService;
	
	@RequestMapping("login")
	public ModelAndView login(User user,HttpServletRequest request){
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
				request.getSession().setAttribute("user", user);
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
}

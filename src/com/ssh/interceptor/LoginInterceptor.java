package com.ssh.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * 在Handler执行完成之后执行，因为是在Controller执行之后的，所以一般用于统一的异常或者日志处理操作
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("execute afterCompletion!");
		
	}
	/**
	 * 在Handler执行之后，返回ModelAndView之前执行，用于统一的View渲染操作，
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("execute postHandle!");
		
	}
	/**
	 * 拦截操作，在执行Handler之前，如果该方法返回的是false，那么就不会执行Handler以及之后的所有操作
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 我们定义登录拦截操作

		/**
		 * 获取访问的URI
		 */
		String submitPath = "user/login";
		String contextPath = request.getContextPath();
		String targetURI = request.getRequestURI().replace(contextPath + "/", "");
		
		HttpSession session = request.getSession();
		/** 未登录 */
		//如果session中的用户信息为空
		if (session.getAttribute("user") == null) {
			
			/** 登陆路径不拦截 */
			response.sendRedirect(request.getContextPath()+"/common/login");
		}
		
		/** 已登录 */
		return true;
	}
	
}

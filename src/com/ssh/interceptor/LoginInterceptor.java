package com.ssh.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * ��Handlerִ�����֮��ִ�У���Ϊ����Controllerִ��֮��ģ�����һ������ͳһ���쳣������־�������
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("execute afterCompletion!");
		
	}
	/**
	 * ��Handlerִ��֮�󣬷���ModelAndView֮ǰִ�У�����ͳһ��View��Ⱦ������
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("execute postHandle!");
		
	}
	/**
	 * ���ز�������ִ��Handler֮ǰ������÷������ص���false����ô�Ͳ���ִ��Handler�Լ�֮������в���
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// ���Ƕ����¼���ز���

		/**
		 * ��ȡ���ʵ�URI
		 */
		String submitPath = "user/login";
		String contextPath = request.getContextPath();
		String targetURI = request.getRequestURI().replace(contextPath + "/", "");
		
		HttpSession session = request.getSession();
		/** δ��¼ */
		//���session�е��û���ϢΪ��
		if (session.getAttribute("user") == null) {
			
			/** ��½·�������� */
			response.sendRedirect(request.getContextPath()+"/common/login");
		}
		
		/** �ѵ�¼ */
		return true;
	}
	
}

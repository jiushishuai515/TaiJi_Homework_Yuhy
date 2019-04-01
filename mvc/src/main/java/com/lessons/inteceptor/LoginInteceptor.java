package com.lessons.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInteceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        System.out.println("login preHandle comming");
        if("/hello/login".equals(request.getServletPath())
        	|| "/hello/join".equals(request.getServletPath())	
        		){
        	return true;
        }
        else if(StringUtils.isEmpty(request.getSession().getAttribute("username"))){
        	response.sendRedirect(request.getContextPath()+"/hello/login");
        	return false;
        }
        else{
		return true;
        }
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("login postHandle comming");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("login afterCompletion comming");
	}
	
}

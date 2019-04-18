package com.taiji.yuhongyue.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.taiji.yuhongyue.service.UserService;

@Component
public class MyInterceptor implements HandlerInterceptor {

	@Autowired
	UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// true是放行
		// 每一个项目对于登陆的实现逻辑都有所区别，我这里使用最简单的Session提取User来验证登陆。
		HttpSession session = request.getSession();
		// 这里的User是登陆时放入session的

		// 如果session中没有user，表示没登陆
		if (session.getAttribute("user") == null) {
			// 这个方法返回false表示忽略当前请求，如果一个用户调用了需要登陆才能使用的接口，如果他没有登陆这里会直接忽略掉
//			request.setAttribute("msg", "请先登录");
//			request.getRequestDispatcher("/login").forward(request,response);
//			response.sendRedirect("/login");
			return false;
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}

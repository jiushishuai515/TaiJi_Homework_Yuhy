package com.taiji.yuhongyue.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import java.io.IOException;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/a","/b"})
@Order(2)
public class LoginFilter implements Filter {

	Logger log = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain1)
			throws IOException, ServletException {
		// 获取配置参数
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();	
		// 不带http://域名:端口的地址
//		String uri = request.getRequestURI();
//		if ("/login".equals(uri)||"/submit".equals(uri)) {
//			log.info("please login");
//			HttpSession session = request.getSession();	
//			// 请求的登录，放行
//			chain1.doFilter(request, response);
//		} else {
//			log.info("mapping URL地址不匹配login、submit");
			if (session.getAttribute("username")=="" || session.getAttribute("username")==null) {
				// 重定向到登录页面
				response.sendRedirect(request.getContextPath() + "/index");
			} else {
				// 已经登录，放行
				chain1.doFilter(request, response);
			}
//		}
	}

	@Override
	public void destroy() {	
	}
}
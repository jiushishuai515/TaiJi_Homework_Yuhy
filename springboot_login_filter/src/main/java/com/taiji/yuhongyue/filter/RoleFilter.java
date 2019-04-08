package com.taiji.yuhongyue.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

@WebFilter(filterName = "loginFilter", urlPatterns = {"/a","/b"})
@Order(3)
public class RoleFilter implements Filter{
	
	Logger log = LoggerFactory.getLogger(LoginFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession httpSession = request.getSession();
		
		if (httpSession != null && httpSession.getAttribute("username")!=null){
            String username = (String) httpSession.getAttribute("username");

            String path = request.getServletPath();
            if(username.equals("user") && !path.equals("/b")){
                // 用户user只能访问端口a
                // session不存在user，说明没有登录成功，需要登录
                response.getWriter().write("user only can access b");
                return ;
            }
        }
		 chain2.doFilter(request, response);
	     
		
//		if(httpSession!=null && "admin".equals(httpSession.getAttribute("username")) ) {
//			log.info("admin匹配");
//			chain2.doFilter(request, response);
//		}else if(httpSession!=null && "user".equals(httpSession.getAttribute("username")) && "/b".equals(request.getServletPath())) {
//			log.info("user匹配");
//			chain2.doFilter(request, response);
//		}
//		else {
//			log.info("user权限不足");
//			response.getWriter().write("user权限不足");
//			response.sendRedirect(request.getContextPath()+"/index");
//		}
			

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

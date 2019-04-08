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

@WebFilter(urlPatterns="/logout")
@Order(1)
public class LogoutFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(LogoutFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		HttpSession session = request.getSession();
		String path = request.getServletPath();
        if ("/logout".equals(path)) {
            // 如果当前调用的是登出接口
            if (session == null || session.getAttribute("username") == null) {
                //用户session不存在，处于已经登出状态，直接返回
                response.getWriter().write("user logged out ");
                return;
            }
            // 如果是登出端口，则直接删除session进行登出操作，不用进入到controller 层
            session.removeAttribute("username");
            response.getWriter().write("logout success");
            return;
        }

        chain.doFilter(request, response);
        
		response.getWriter().write("ogout success");
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

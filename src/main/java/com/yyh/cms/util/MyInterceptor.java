package com.yyh.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @ClassName: MyInterceptor
 * @Description: 个人中心拦截器
 * @author: dell
 * @date: 2020年5月9日 下午2:23:14
 */
public class MyInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 如果用户已经登录 则不拦截
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		// 如果用户存在 则不拦截
		if (obj != null) {
			return true;
		}
		// 用户没有登录则 进行拦截 转发到登录页面
		request.setAttribute("msg", "请先登录");
		request.getRequestDispatcher("/WEB-INF/view/passport/login.jsp").forward(request, response);

		return false;
	}

}

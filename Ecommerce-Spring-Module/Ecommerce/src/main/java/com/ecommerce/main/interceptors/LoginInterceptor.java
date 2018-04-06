package com.ecommerce.main.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);

		boolean alreadyLoggedIn = request.getSession().getAttribute("user") != null;
		boolean loginPageRequested = rm != null && rm.value().length > 0 && "login".equals(rm.value()[0]);

		if (alreadyLoggedIn && loginPageRequested) {
			response.sendRedirect("already login");
			return false;
		} else if (!alreadyLoggedIn && !loginPageRequested) {
			response.sendRedirect("Already Login");
			return false;
		}

		return true;

		// return super.preHandle(request,response,handler);

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}

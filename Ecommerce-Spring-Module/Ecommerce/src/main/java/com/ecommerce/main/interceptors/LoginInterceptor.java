package com.ecommerce.main.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	JwtValidator jwtValidator;
	
	@Autowired
	UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		/*RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);
	
		//System.out.println(rm.value()[0]);
		
		if(rm.value()[0].contains("user"))
			{
			 	System.out.println(rm.value()[0]);
						String token = request.getHeader("token");
						User user = jwtValidator.validate(token);
						
						if(userService.loginUser(user)!=null)
							return true;
						
						else
							return false;			
			}*/
		return true;
		}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		/*
			TokenProvider tokenProvider =new TokenProvider();
			User userToken = new User();
			userToken.setEmailAddress(user.getEmailId());
			userToken.setId(user.getPhoneNumber());
			userToken.setName(user.getName());
			userToken.setRole("User");
	
			String token = tokenProvider.generate(userToken);
		
	*/			super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

}

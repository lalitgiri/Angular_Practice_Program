package com.ecommerce.main.interceptors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SessionController {

	 @Autowired
	    private UserService userService;
/*
	    @RequestMapping(value = "login", method = RequestMethod.GET)
	    public String handleLoginGetRequest () {
	        return "user-login";
	    }
*/
	    //@RequestMapping(value = "login", method = RequestMethod.POST)
	    public String handleLoginRequest (User user, Model model,
	                                          HttpServletRequest request) {

	        User loggedUser = userService.loginUser(user);
	        if (loggedUser == null) {
	            request.getSession(true)
	                   .setAttribute("user", loggedUser);
	            return "Session Generated";
	        } else {
	            model.addAttribute("error", "Not a valid user");
	            return "user-login";
	        }
	    }

/*	    @RequestMapping(value = "app/**", method = RequestMethod.GET)
	    public String handleAppRequest (Model model, HttpServletRequest request) {
	        model.addAttribute("uri", request.getRequestURI());
	        model.addAttribute("user", request.getAttribute("user"));
	        return "app-page";
	    }*/
}

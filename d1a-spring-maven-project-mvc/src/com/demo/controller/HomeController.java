/*
 * package com.demo.controller; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * @Controller
 * 
 * public class HomeController {
 * 
 * @RequestMapping(value="/", method= RequestMethod(GET)) public String home() {
 * return "home"; }
 * 
 * }
 */


package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.model.User;

@Controller
public class HomeController {
//returns home view name
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("message", "Message from controller");
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user( User user, Model model) {
		System.out.println("User Page Requested");
		model.addAttribute("userName", user.getUserName());
		return "user";
	}
}
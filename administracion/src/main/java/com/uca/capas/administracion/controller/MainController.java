package com.uca.capas.administracion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/login")
	public ModelAndView index()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	@RequestMapping("/menu")
	public ModelAndView menu()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("menu");
		return mav;
	}
	@RequestMapping("/user")
	public ModelAndView user()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user");
		return mav;
	}
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin");
		return mav;
	}

}

package com.uca.capas.administracion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("/login")
    public ModelAndView login () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
	
	@RequestMapping("/menu")
    public ModelAndView menu () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        return mav;
    }
}

package com.uca.capas.administracion.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.service.UserDetailServiceImpl;
import com.uca.capas.administracion.service.UserService;
import com.uca.capas.administracion.service.UserServiceImpl;	



@Controller
public class MainController {
	
	@Autowired 
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDetailServiceImpl userServiceDetail;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/login")
    public ModelAndView login () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
	
	@RequestMapping("/menu")
    public ModelAndView menu () {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("menu");
        return mav;
    }
	
	@RequestMapping("/admin")
    public ModelAndView admin() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/admin");
        return mav;
    }
	
	@RequestMapping("/prueba")
    public ModelAndView prueba() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin/prueba");
        return mav;
    }
	
	
	@RequestMapping("/user")
	public ModelAndView us()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/user");
		return mav;
	}
	
	@RequestMapping("/registro")
	public ModelAndView registro()
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", new User());
		mav.setViewName("registro");
		return mav;
	}
	
	@RequestMapping("/registrarusuario")
	public ModelAndView registrarUsuario(@Valid @ModelAttribute User user, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			mav.setViewName("registro");
		}
		else
		{	
			user.setInserted(false);
			user.setEnabled(false);
			user.setPass(encoder.encode(user.getPass()));
			userService.save(user);			
			mav.addObject("resultado", 1);
			mav.setViewName("index");
		}
		
		return mav;
	}
}

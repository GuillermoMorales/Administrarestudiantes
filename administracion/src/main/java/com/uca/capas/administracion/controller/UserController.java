package com.uca.capas.administracion.controller;



import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.administracion.domain.Expedient;
import com.uca.capas.administracion.domain.Municipality;
import com.uca.capas.administracion.domain.School;
import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.service.ExpedientService;
import com.uca.capas.administracion.service.MunicipalityService;
import com.uca.capas.administracion.service.SchoolService;
import com.uca.capas.administracion.service.UserDetailServiceImpl;


@Controller
public class UserController {
	
	
	@Autowired
	UserDetailServiceImpl userServiceDetail;
	
	@Autowired
	MunicipalityService municipalityService;
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	ExpedientService expedientService;
	

	@RequestMapping("/userProcess")
    public ModelAndView pruebau() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/procesos");
        return mav;
    }
	
	
	@RequestMapping("/userExpedient")
    public ModelAndView expediente() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("user/expedient");
        return mav;
    }
	
	@RequestMapping("/userAddExpedient")
    public ModelAndView addexpedient() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("expedient", new Expedient());
        
        
        List<Municipality> municipalities= null;
        List<School> schools= null;
		try {
			municipalities =  municipalityService.showAll();

			schools =  schoolService.showAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("municipalities",municipalities);
		mav.addObject("schools",schools);
		
        
        mav.setViewName("user/addexpedient");
        return mav;   
    }

	@RequestMapping("/registerExpedient")
	public ModelAndView registerExpedient(@Valid @ModelAttribute Expedient expedient, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors())
		{
			List<Municipality> municipalities= null;
	        List<School> schools= null;
	        
	    	try {
				municipalities =  municipalityService.showAll();

				schools =  schoolService.showAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    	mav.addObject("municipalities",municipalities);
			mav.addObject("schools",schools);
			
			mav.setViewName("user/addexpedient");
		}
		else
		{	
			try {
			expedientService.save(expedient);
			mav.addObject("resultado", 1);
			
			}
			catch(Exception e){
				e.printStackTrace();
				mav.clear();
				mav.addObject("resultado", 2);
				
				mav.addObject("error", e.toString());
			}
			mav.setViewName("user/expedient");
		}
		
		return mav;
	}
	
	
	

	

}


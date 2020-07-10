package com.uca.capas.administracion.controller;



import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.administracion.domain.Expedient;
import com.uca.capas.administracion.domain.Municipality;
import com.uca.capas.administracion.domain.S_Expedient;
import com.uca.capas.administracion.domain.School;
import com.uca.capas.administracion.domain.Subject;
import com.uca.capas.administracion.domain.User;
import com.uca.capas.administracion.service.ExpedientService;
import com.uca.capas.administracion.service.MunicipalityService;
import com.uca.capas.administracion.service.S_ExpedientService;
import com.uca.capas.administracion.service.SchoolService;
import com.uca.capas.administracion.service.SubjectService;
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
	
	@Autowired
	S_ExpedientService subjectExpedientService;
	
	@Autowired
	SubjectService subjectService;
	

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
	
	@RequestMapping("/userSearch")
	public ModelAndView userSearch(@RequestParam Integer soption, @RequestParam String cadena) {
		ModelAndView mav = new ModelAndView();
		List <Expedient> expedients= null;
		
		if(soption==1) {
		expedients=expedientService.findByNameLike(cadena);
		
		}else if(soption==2) {
			expedients=expedientService.findBySurnameLike(cadena);
		}else {
			System.out.println("error en el seleccionable");
		}
		mav.addObject("expedients", expedients);
		mav.setViewName("user/expedientlist");
		return mav;
	}
	
	 @GetMapping("editExpedient/{id}")
	    public String showSubject(Model model, @PathVariable("id") Integer id) {
	        Optional<Expedient> expedient = expedientService.findById(id);
	        
	        
	        List<Municipality> municipalities= null;
	        List<School> schools= null;
			try {
				municipalities =  municipalityService.showAll();

				schools =  schoolService.showAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("municipalities",municipalities);
			model.addAttribute("schools",schools);
	        
	        if (expedient.isPresent()) {
	            model.addAttribute("expedient", expedient.get());
	        } else {
	            return "user/expedient";
	        }
	        return "user/editexpedient";
	    }
	
	 @PostMapping("/updateExpedient")
	    public String updateExpedient(Model model, @Valid @ModelAttribute Expedient expedient, BindingResult result) {
	        if (result.hasErrors()) {
	            List<Municipality> municipalities= null;
		        List<School> schools= null;
				try {
					municipalities =  municipalityService.showAll();

					schools =  schoolService.showAll();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				model.addAttribute("municipalities",municipalities);
				model.addAttribute("schools",schools);
	        	
	        	return "user/editexpedient";
	        }

	        try {
	            Optional<Expedient> exp = expedientService.findById(expedient.getId());
	            if (exp.isPresent()) {
	            	exp.get().setId(expedient.getId());
	                exp.get().setName(expedient.getName());
	                exp.get().setSurname(expedient.getSurname());
	                exp.get().setCarnet(expedient.getCarnet());
	                exp.get().setAddress(expedient.getAddress());
	                exp.get().setHome_phone(expedient.getHome_phone());
	                exp.get().setMobile_phone(expedient.getMobile_phone());
	                exp.get().setMothers_name(expedient.getMothers_name());
	                exp.get().setFathers_name(expedient.getFathers_name());
	                exp.get().setSchool_fk(expedient.getSchool_fk());
	                exp.get().setBirth_date(expedient.getBirth_date());
	                System.out.println("El id es:");
	                System.out.println(exp.get().getId());
	                expedientService.save(exp.get());
	                model.addAttribute("expedient", exp.get());
	            }
	            model.addAttribute("success", true);
	            List<Municipality> municipalities= null;
		        List<School> schools= null;
				try {
					municipalities =  municipalityService.showAll();

					schools =  schoolService.showAll();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				model.addAttribute("municipalities",municipalities);
				model.addAttribute("schools",schools);
	        } catch (Exception e) {
	            List<Municipality> municipalities= null;
		        List<School> schools= null;
				try {
					municipalities =  municipalityService.showAll();
					schools =  schoolService.showAll();
				}catch(Exception d) {
					e.printStackTrace();
				}
				
				model.addAttribute("municipalities",municipalities);
				model.addAttribute("schools",schools);
	            model.addAttribute("error", e);
	        }
	        return "user/editexpedient";
	    }

	 @GetMapping("expedientSubject/{id}")
	    public String expedientSubject(Model model, @PathVariable("id") Integer id) {
	        
		 List<S_Expedient> subjectExpedients = null;
		 Optional<Expedient> expedient = null;
		List<Subject> subjects = null;
		
	          
			try {
				subjectExpedients = subjectExpedientService.findSubExpedientsById(id);
				expedient = expedientService.findById(id);
				subjects = subjectService.showAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("subjectexpedients",subjectExpedients);
			//expedient.get().getName();
			//expedient.get().getSurname();
			model.addAttribute("expedient", expedient);
			model.addAttribute("subjects", subjects);
			
			
			
			
	        
			 System.out.println(subjectExpedients.size());
	        return "user/subjectexpedientlist";
	    }
	 
	 @GetMapping("expedientSubject/editSubject/{id}")
	    public String editSubject(Model model, @PathVariable("id") Integer id) {
	        
		 List<S_Expedient> subjectExpedients = null;
		 Optional<Expedient> expedient = null;
		List<Subject> subjects = null;
		
	          
			try {
				subjectExpedients = subjectExpedientService.findSubExpedientsById(id);
				expedient = expedientService.findById(id);
				subjects = subjectService.showAll();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			model.addAttribute("subjectexpedients",subjectExpedients);
			//expedient.get().getName();
			//expedient.get().getSurname();
			model.addAttribute("expedient", expedient);
			model.addAttribute("subjects", subjects);
			
			
			
			
	        
			 System.out.println(subjectExpedients.size());
	        return "user/editsubjectexpedient";
	    }
	 
	 @RequestMapping("/expedientSubject/addNewSubject/{id}")
		public ModelAndView addSubjectExpedient(@Valid @ModelAttribute Expedient expedient, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			if (result.hasErrors())
			{
				List<Subject> subjects= null;
		        
		    	try {
					subjects =  subjectService.showAll();
				}catch(Exception e) {
					e.printStackTrace();
				}
		    	mav.addObject("subjects", subjects);
				
				mav.setViewName("user/subject");
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


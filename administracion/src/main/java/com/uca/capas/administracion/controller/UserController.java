package com.uca.capas.administracion.controller;


import com.uca.capas.administracion.domain.*;
import com.uca.capas.administracion.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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


        List<Municipality> municipalities = null;
        List<School> schools = null;
        try {
            municipalities = municipalityService.showAll();

            schools = schoolService.showAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("municipalities", municipalities);
        mav.addObject("schools", schools);


        mav.setViewName("user/addexpedient");
        return mav;
    }

    @RequestMapping("/registerExpedient")
    public ModelAndView registerExpedient(@Valid @ModelAttribute Expedient expedient, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if (result.hasErrors()) {
            List<Municipality> municipalities = null;
            List<School> schools = null;

            try {
                municipalities = municipalityService.showAll();

                schools = schoolService.showAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("municipalities", municipalities);
            mav.addObject("schools", schools);

            mav.setViewName("user/addexpedient");
        } else {
            try {
                expedientService.save(expedient);
                mav.addObject("resultado", 1);

            } catch (Exception e) {
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
        List<Expedient> expedients = null;

       

        if (soption == 1) {
            expedients = expedientService.findByNameLike(cadena);

        } else if (soption == 2) {
            expedients = expedientService.findBySurnameLike(cadena);
        } else {
            System.out.println("error en el seleccionable");
        }
        System.out.println("Antes del for");
        for(int i=0;i<expedients.size();i++) {

        	System.out.println("el id es "+ expedients.get(i).getId());
        	List<S_Expedient> approved = subjectExpedientService.getByResult(expedients.get(i).getId(), "aprobada");
            List<S_Expedient> reproved = subjectExpedientService.getByResult(expedients.get(i).getId(), "reprobada");
            
            double average = subjectExpedientService.getAvg(expedients.get(i).getId());
            if(approved!=null) {

                expedients.get(i).setApro(approved.size());	
            	
            }else {
            	 expedients.get(i).setApro(0);	
            }
            
            if(reproved!=null) {

            	expedients.get(i).setRepro(reproved.size());
                	
            }else {
            	expedients.get(i).setRepro(0);
            }
            
          

                expedients.get(i).setAvg(average);
                
           

        	
        }
        
        mav.addObject("expedients", expedients);
        
        mav.setViewName("user/expedientlist");
        mav.setViewName("user/expedientlist");
        return mav;
    }

    @GetMapping("editExpedient/{id}")
    public String showSubject(Model model, @PathVariable("id") Integer id) {
        Optional<Expedient> expedient = expedientService.findById(id);


        List<Municipality> municipalities = null;
        List<School> schools = null;
        try {
            municipalities = municipalityService.showAll();

            schools = schoolService.showAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("municipalities", municipalities);
        model.addAttribute("schools", schools);

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
            List<Municipality> municipalities = null;
            List<School> schools = null;
            try {
                municipalities = municipalityService.showAll();

                schools = schoolService.showAll();
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("municipalities", municipalities);
            model.addAttribute("schools", schools);

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
            List<Municipality> municipalities = null;
            List<School> schools = null;
            try {
                municipalities = municipalityService.showAll();

                schools = schoolService.showAll();
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("municipalities", municipalities);
            model.addAttribute("schools", schools);
        } catch (Exception e) {
            List<Municipality> municipalities = null;
            List<School> schools = null;
            try {
                municipalities = municipalityService.showAll();
                schools = schoolService.showAll();
            } catch (Exception d) {
                e.printStackTrace();
            }

            model.addAttribute("municipalities", municipalities);
            model.addAttribute("schools", schools);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("subjectexpedients", subjectExpedients);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("subjectexpedients", subjectExpedients);
        //expedient.get().getName();
        //expedient.get().getSurname();
        model.addAttribute("expedient", expedient);
        model.addAttribute("subjects", subjects);


        System.out.println(subjectExpedients.size());
        return "user/editsubjectexpedient";
    }

    @RequestMapping("/addSubject")
    public ModelAndView addSubjectExpedient(@Valid @ModelAttribute S_Expedient s_expedient, BindingResult result) {
        ModelAndView mav = new ModelAndView();
       
        if (result.hasErrors()) {
            List<Subject> subjects = null;

            try {
                subjects = subjectService.showAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mav.addObject("subjects", subjects);

            mav.setViewName("user/subject");
        } else {
            try {
            	subjectExpedientService.save(s_expedient);
                mav.addObject("resultado", 1);

            } catch (Exception e) {
                e.printStackTrace();
                mav.clear();
                mav.addObject("resultado", 2);

                mav.addObject("error", e.toString());
            }
            mav.setViewName("user/expedient");
        }

        return mav;
    }
    
    @RequestMapping("/expedientSubject/addNewSubject/{id}")
    public ModelAndView addSubject(Model model, @PathVariable("id") Integer id) {
        ModelAndView mav = new ModelAndView();
        S_Expedient s_expedient = new S_Expedient();
        s_expedient.setExpedient_id_fk(id);
        
        mav.addObject("s_expedient", s_expedient);
        
       

        List<Subject> subjects = null;
        
        try {
            subjects = subjectService.showAll();

            
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("subjects", subjects);
        
       mav.addObject("idexpedient",id);
       

        mav.setViewName("user/addsubject");
        return mav;
    }


}


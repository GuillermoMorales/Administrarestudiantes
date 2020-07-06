package com.uca.capas.administracion.controller;

import com.uca.capas.administracion.domain.School;
import com.uca.capas.administracion.service.MunicipalityService;
import com.uca.capas.administracion.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    MunicipalityService municipalityService;

    @GetMapping("escuelas")
    public String showSchools(Model model) {
        model.addAttribute("schoolList", schoolService.showAll());
        return "admin/schools/list";
    }

    @GetMapping("escuelas/{id}")
    public String showSchool(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("school", schoolService.findById(id));
        model.addAttribute("municipalities", municipalityService.showAll());
        return "admin/schools/detail";
    }

    @PostMapping("escuelas/update")
    public String updateSchool(Model model, @ModelAttribute School school) {
        model.addAttribute("municipalities", municipalityService.showAll());
        model.addAttribute("school", schoolService.findById(school.getId()));
        try {
            Optional<School> sch = schoolService.findById(school.getId());
            if (sch.isPresent()) {
                sch.get().setMunicipality_fk(school.getMunicipality_fk());
                sch.get().setName(school.getName());
                schoolService.save(sch.get());
            }
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "admin/schools/detail";
    }
}

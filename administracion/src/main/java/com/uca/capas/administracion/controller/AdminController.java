package com.uca.capas.administracion.controller;

import com.uca.capas.administracion.domain.School;
import com.uca.capas.administracion.domain.Subject;
import com.uca.capas.administracion.service.MunicipalityService;
import com.uca.capas.administracion.service.SchoolService;
import com.uca.capas.administracion.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class AdminController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    MunicipalityService municipalityService;

    @Autowired
    SubjectService subjectService;

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

    @GetMapping("escuelas/add")
    public String addSchoolView(Model model) {
        model.addAttribute("school", new School());
        model.addAttribute("municipalities", municipalityService.showAll());
        return "admin/schools/create";
    }

    @PostMapping("escuelas/add")
    public String addSchool(Model model, @Valid @ModelAttribute School school, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/schools/create";
        }

        schoolService.save(school);

        model.addAttribute("schoolList", schoolService.showAll());
        return "redirect:/escuelas";
    }

    @GetMapping("materias")
    public String showSubjects(Model model) {
        model.addAttribute("subjectsList", subjectService.showAll());
        return "admin/subjects/list";
    }

    @GetMapping("materias/{id}")
    public String showSubject(Model model, @PathVariable("id") Integer id) {
        Optional<Subject> subject = subjectService.findById(id);
        if (subject.isPresent()) {
            model.addAttribute("subject", subject.get());
        } else {
            return "admin/subjects/list";
        }
        return "admin/subjects/detail";
    }

    @GetMapping("materias/add")
    public String addSubjectView(Model model) {
        model.addAttribute("subject", new Subject());
        return "admin/subjects/create";
    }

    @PostMapping("materias/add")
    public String addSubject(Model model, @Valid @ModelAttribute Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/subjects/create";
        }

        subjectService.save(subject);

        model.addAttribute("subjectsList", subjectService.showAll());
        return "redirect:/materias";
    }

    @PostMapping("materias/update")
    public String updateSubject(Model model, @Valid @ModelAttribute Subject subject, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/subjects/detail";
        }

        try {
            Optional<Subject> subj = subjectService.findById(subject.getId());
            if (subj.isPresent()) {
                subj.get().setCode(subject.getCode());
                subj.get().setDescription(subject.getDescription());
                subj.get().setStatus(subject.getStatus());
                subjectService.save(subj.get());
                model.addAttribute("subject", subj.get());
            }
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "admin/subjects/detail";
    }
}

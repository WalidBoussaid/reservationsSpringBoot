package be.icc.pid.reservationsSpringBoot.controller;

import be.icc.pid.reservationsSpringBoot.model.Locality;
import be.icc.pid.reservationsSpringBoot.model.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LocalityController {
    @Autowired
    LocalityService service;

    //…

    @GetMapping("/localities/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Locality locality = service.get(id);

        model.addAttribute("locality", locality);
        model.addAttribute("title", "Fiche d'une localité");

        return "locality/show";
    }

}


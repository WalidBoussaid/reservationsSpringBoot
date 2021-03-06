package be.icc.pid.reservationsSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import be.icc.pid.reservationsSpringBoot.model.ArtistType;
import be.icc.pid.reservationsSpringBoot.model.Show;
import be.icc.pid.reservationsSpringBoot.model.ShowService;
import be.icc.pid.reservationsSpringBoot.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@Controller
public class ShowController {
    @Autowired
    ShowService service;

    @GetMapping("/shows")
    public String index(Model model) {
        List<Show> shows = service.getAll();

        model.addAttribute("shows", shows);
        model.addAttribute("title", "Liste des spectacles");
        return "show/index";
    }

    @GetMapping("/shows/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Show show = service.get(id);

        //Récupérer les artistes du spectacle et les grouper par type
        Map<Type,ArrayList<ArtistType>> collaborateurs = new TreeMap<>();

        for(ArtistType at : show.getArtistTypes()) {
            if(collaborateurs.get(at.getType()) == null) {
                collaborateurs.put(at.getType(), new ArrayList<>());
            }

            collaborateurs.get(at.getType().getType());
        }

        model.addAttribute("collaborateurs", collaborateurs);
        model.addAttribute("show", show);
        model.addAttribute("title", "Fiche d'un spectacle");

        return "show/show";
    }


}


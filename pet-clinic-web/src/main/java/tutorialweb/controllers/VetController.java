package tutorialweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tutorialweb.petweb.services.VetService;
import tutorialweb.petweb.services.map.VetServiceMap;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vet/index","vets/index.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
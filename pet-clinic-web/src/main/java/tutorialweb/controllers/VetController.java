package tutorialweb.controllers;

import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tutorialweb.petweb.model.Vet;
import tutorialweb.petweb.services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vet/index","vets/index.html","/vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
    @GetMapping("api/vets")
    public @ResponseBody Set<Vet> getVetJson (Model model){
        return vetService.findAll();
    }
}

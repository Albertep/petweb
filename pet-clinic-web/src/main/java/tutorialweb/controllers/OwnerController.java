package tutorialweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tutorialweb.petweb.model.Owner;
import tutorialweb.petweb.model.Pet;
import tutorialweb.petweb.services.OwnerService;
import tutorialweb.petweb.services.PetService;

import java.util.HashMap;
import java.util.Set;


@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;
    private final PetService petService;

    public OwnerController(OwnerService ownerService, PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @RequestMapping({"","/index","/index.html"})
    public String listOwners(Model model){
        model.addAttribute("prop",ownerService.findAll());
        Set<Owner> own=ownerService.findAll();
        own.forEach(owner -> {
            owner.getPets().forEach(pet -> {
                System.out.println(pet.getPetType().getName());
            });
        });
        HashMap<Owner, Set<Pet>> ownpets= new HashMap<>();
        System.out.println("-------------------------------------");
        for (Owner owner : own) {
            ownpets.put(owner, owner.getPets());
            ownpets.values().forEach(pets -> {
                pets.forEach(pet -> {
                    System.out.println(pet.getPetType().getName());
                });
            });
        }
        model.addAttribute("ownpets",ownpets);
        return "owners/index";
    }
    @RequestMapping({"/find"})
    public String findOwners(){
        return "notimplemented";
    }
}

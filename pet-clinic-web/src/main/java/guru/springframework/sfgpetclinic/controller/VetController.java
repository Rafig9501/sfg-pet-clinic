package guru.springframework.sfgpetclinic.controller;

import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"/vet", "/vets"})
    public String listOfVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vet/vet";
    }
}

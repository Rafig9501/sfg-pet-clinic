package guru.springframework.sfgpetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetController {

    @GetMapping({"/vet", "/vets"})
    public String listOfVets(){
        return "vet/vet";
    }
}

package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Adams");
        ownerService.save(owner1);
        Owner owner2 = new Owner();
        owner2.setFirstName("Kate");
        owner2.setLastName("Anabel");
        ownerService.save(owner2);
        System.out.println("Owners saved");
        Vet vet1 = new Vet();
        vet1.setFirstName("Mickey");
        vet1.setLastName("Mouse");
        vetService.save(vet1);
        Vet vet2 = new Vet();
        vet2.setFirstName("Guf");
        vet2.setLastName("Duck");
        vetService.save(vet2);
        System.out.println("Vets saved");
        PetType dog = new PetType();
        dog.setName("Togo");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        dog.setName("MurMur");
        PetType savedCatPetType = petTypeService.save(dog);
        System.out.println("Pet Types saved");
    }
}

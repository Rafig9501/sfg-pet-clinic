package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.SpecialtyService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Adams");
        owner1.setAddress("123 Bribeckel");
        owner1.setCity("Miami");
        owner1.setPhone("+123214122123");

        PetType savedCatType = petTypeService.save(new PetType("cat"));
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatType);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Kate");
        owner2.setLastName("Anabel");
        owner2.setAddress("123 Bribeckel");
        owner2.setCity("Miami");
        owner2.setPhone("+123214122123");

        Pet fionasCat = new Pet();
        fionasCat.setName("Fifioha");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);
        fionasCat.setPetType(savedCatType);

        ownerService.save(owner2);
        System.out.println("Owners saved");

        Specialty radiology = new Specialty("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Mickey");
        vet1.setLastName("Mouse");
        vet1.getSpecialties().add(savedRadiology);
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Guf");
        vet2.setLastName("Duck");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Vets saved");

        PetType dog = new PetType();
        dog.setTypeName("Togo");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setTypeName("MurMur");
        PetType savedCatPetType = petTypeService.save(dog);
        System.out.println("Pet Types saved");
    }
}

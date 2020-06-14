package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.SpecialtyService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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
        Owner owner1 = Owner.builder().firstName("John").lastName("Adams").address("123 Bribeckel")
                .city("Miami").phone("+123214122123").build();

        PetType savedCatType = petTypeService.save(PetType.builder().typeName("cat").build());
        Pet mikesPet = Pet.builder().petType(savedCatType).birthDate(LocalDate.now())
                .owner(owner1).name("Rosco").build();

        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = Owner.builder().firstName("Kate").lastName("Anabel").address("123 Bribeckel")
                .city("Miami").phone("+123214122123").build();

        Pet fionasCat = Pet.builder().name("Fifioha").owner(owner2).birthDate(LocalDate.now())
                .petType(savedCatType).build();
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);
        System.out.println("Owners saved");

        Specialty radiology = Specialty.builder().description("radiology").build();
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = Specialty.builder().description("surgery").build();
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = Specialty.builder().description("dentistry").build();
        Specialty savedDentistry = specialtyService.save(dentistry);

        Set<Specialty> mickeySpecialities = new HashSet<>();
        mickeySpecialities.add(savedRadiology);
        mickeySpecialities.add(savedDentistry);
        Vet vet1 = Vet.builder().firstName("Mickey").lastName("Mouse").specialties(mickeySpecialities).build();
        vetService.save(vet1);

        Set<Specialty> gufSpecialities = new HashSet<>();
        gufSpecialities.add(savedSurgery);
        Vet vet2 = Vet.builder().firstName("Guf").lastName("Duck").specialties(gufSpecialities).build();
        vetService.save(vet2);
        System.out.println("Vets saved");

        PetType dog = PetType.builder().typeName("Togo").build();
        petTypeService.save(dog);

        PetType cat = PetType.builder().typeName("MurMur").build();
        petTypeService.save(cat);
        System.out.println("Pet Types saved");
    }
}

package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() != null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        } else throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }
        }
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vet extends Person {

    private Set<Specialty> specialties;
}

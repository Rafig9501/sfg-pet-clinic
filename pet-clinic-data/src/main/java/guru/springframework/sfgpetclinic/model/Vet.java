package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Vet extends Person {

    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}

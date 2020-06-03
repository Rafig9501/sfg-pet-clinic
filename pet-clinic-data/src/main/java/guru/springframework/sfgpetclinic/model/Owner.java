package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Owner extends Person {

    public Owner(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}

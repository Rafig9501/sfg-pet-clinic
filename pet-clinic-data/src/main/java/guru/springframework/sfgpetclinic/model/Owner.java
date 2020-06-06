package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class Owner extends Person {

    private String address;
    private String city;
    private String phone;
    private Set<Pet> pets = new HashSet<>();
}

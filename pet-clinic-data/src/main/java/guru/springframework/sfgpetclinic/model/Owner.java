package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(exclude = {"pets"}, callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Owner extends Person {

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city,
                 String phone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.phone = phone;

        if(pets != null) {
            this.pets = pets;
        }
    }

    @Column
    @NonNull
    private String address;

    @Column
    @NonNull
    private String city;

    @Column
    @NonNull
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @NonNull
    private Set<Pet> pets = new HashSet<>();
}

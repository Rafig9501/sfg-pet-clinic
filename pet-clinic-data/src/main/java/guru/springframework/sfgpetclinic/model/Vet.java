package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true, exclude = {"specialties"})
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Vet extends Person {

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    @Builder
    public Vet(Long id, String firstName, String lastName, Set<Specialty> specialties) {
        super(id, firstName, lastName);
        this.specialties = specialties;
    }
}

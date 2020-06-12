package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Pet extends BaseEntity{

    @Column
    private String name;

    @Column
    @ManyToOne
    @JoinColumn("type_id")
    private PetType petType;

    @Column
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column
    private LocalDate birthDate;

    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}

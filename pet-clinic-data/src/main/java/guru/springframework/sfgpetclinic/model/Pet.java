package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pet")
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
}

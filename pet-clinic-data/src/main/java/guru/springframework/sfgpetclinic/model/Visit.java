package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
public class Visit extends BaseEntity {

    @Column
    private LocalDate date;

    @Column
    private String description;

    @Column
    @JoinColumn(name = "pet_id")
    private Pet pet;
}

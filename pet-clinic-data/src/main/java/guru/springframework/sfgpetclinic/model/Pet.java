package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class Pet extends BaseEntity{

    private PetType petType;
    private Owner owner;
    private LocalDate birthDate;
}

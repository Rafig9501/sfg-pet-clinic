package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@MappedSuperclass
public class Person extends BaseEntity{

    private Long id;
    private String firstName;
    private String lastName;

}

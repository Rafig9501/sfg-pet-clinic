package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet_type")
@Entity
@Data
@Builder
public class PetType extends BaseEntity{

    @Column
    private String typeName;

}

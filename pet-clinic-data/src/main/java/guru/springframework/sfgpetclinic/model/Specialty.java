package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@Entity
public class Specialty extends BaseEntity {

    @Column
    private String description;

    @Builder
    public Specialty(Long id, String description) {
        super(id);
        this.description = description;
    }
}

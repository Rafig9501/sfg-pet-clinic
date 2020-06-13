package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Specialty extends BaseEntity {

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

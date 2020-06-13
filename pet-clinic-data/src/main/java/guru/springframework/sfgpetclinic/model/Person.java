package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.MappedSuperclass;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity{

    private Long id;
    private String firstName;
    private String lastName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package guru.springframework.sfgpetclinic.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Visit {

    private LocalDate date;
    private String description;
    private Pet pet;
}

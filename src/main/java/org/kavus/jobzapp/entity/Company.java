package org.kavus.jobzapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Company extends Organization<LDefinition> {
    public Company(List<Definition> definitionList, LocalDate foundingDate, LocalDateTime registrationDate) {
        super(definitionList, foundingDate, registrationDate);
    }

    public Company() {
        super();
    }

    public Company(LocalDate foundingDate, LocalDateTime registrationDate) {
        super(foundingDate, registrationDate);
    }
}

package org.kavus.jobzapp.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Company extends Organization<LDefinition> {
    public Company(Set<Definition> definitionSet, LocalDate foundingDate, LocalDateTime registrationDate) {
        super(definitionSet, foundingDate, registrationDate);
    }

    public Company() {
        super();
    }

    public Company(LocalDate foundingDate, LocalDateTime registrationDate) {
        super(foundingDate, registrationDate);
    }
}

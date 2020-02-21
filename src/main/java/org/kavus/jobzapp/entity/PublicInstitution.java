package org.kavus.jobzapp.entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
public class PublicInstitution extends Organization<XLDefinition>{
    public PublicInstitution(Set<Definition> definitionSet, LocalDate foundingDate, LocalDateTime registrationDate) {
        super(definitionSet, foundingDate, registrationDate);
    }

    public PublicInstitution(LocalDate foundingDate, LocalDateTime registrationDate) {
        super(foundingDate, registrationDate);
    }
}

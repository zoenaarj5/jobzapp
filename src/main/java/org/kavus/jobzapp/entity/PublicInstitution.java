package org.kavus.jobzapp.entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
public class PublicInstitution extends Organization<XLDefinition>{
    public PublicInstitution(List<Definition> definitionList, LocalDate foundingDate, LocalDateTime registrationDate) {
        super(definitionList, foundingDate, registrationDate);
    }

    public PublicInstitution(LocalDate foundingDate, LocalDateTime registrationDate) {
        super(foundingDate, registrationDate);
    }
}

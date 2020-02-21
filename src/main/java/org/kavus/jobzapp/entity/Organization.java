package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Organization<L extends Definition> extends Definable {
    @Column(name="FOUNDING_DATE")
    protected LocalDate foundingDate;
    @Column(name="REGISTRATION_DATE")
    protected LocalDateTime registrationDate;
    @OneToOne
    @JoinColumn(name="CONTACT_LISTER_ID")
    protected ContactLister contactLister;

    public Organization() {
        super();
    }

    public Organization(List<Definition> definitionList, LocalDate foundingDate, LocalDateTime registrationDate) {
        super(definitionList);
        this.foundingDate = foundingDate;
        this.registrationDate = registrationDate;
    }

    public Organization(LocalDate foundingDate, LocalDateTime registrationDate) {
        this.foundingDate = foundingDate;
        this.registrationDate = registrationDate;
    }
}

package org.kavus.jobzapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MDefinition extends Definition{
    @Length(max = 100)
    protected String name;
    @Length(max = 350)
    protected String description;

    public MDefinition(Definable definable, LanguageCode languageCode, @Length(max = 100) String name, @Length(max = 350) String description) {
        super(definable, languageCode);
        this.name = name;
        this.description = description;
    }

    public MDefinition(@Length(max = 100) String name, @Length(max = 350) String description) {
        this.name = name;
        this.description = description;
    }
}

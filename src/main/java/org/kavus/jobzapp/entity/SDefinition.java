package org.kavus.jobzapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SDefinition extends Definition{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Length(max = 100)
    protected String name;

    public SDefinition(Definable definable, LanguageCode languageCode, @Length(max = 100) String name, @Length(max = 200) String description) {
        super(definable, languageCode);
        this.name = name;
        this.description = description;
    }

    public SDefinition(@Length(max = 100) String name, @Length(max = 200) String description) {
        this.name = name;
        this.description = description;
    }

    @Length(max = 200)
    protected String description;
}

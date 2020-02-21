package org.kavus.jobzapp.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Experience extends Asset{
    @ManyToOne
    @JoinColumn(name="PERSON_ID")
    protected Person person;
    @ManyToOne
    @JoinColumn(name="ORGANIZATION_ID")
    protected Organization<Definition> organization;
    @ManyToOne
    @JoinColumn(name="TYPE_ID")
    protected ExperienceType experienceType;
    protected float duration;

    public Experience(Person person, Organization<Definition> organization, ExperienceType experienceType, float duration) {
        this.person = person;
        this.organization = organization;
        this.experienceType = experienceType;
        this.duration = duration;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Organization<Definition> getOrganization() {
        return organization;
    }

    public void setOrganization(Organization<Definition> organization) {
        this.organization = organization;
    }

    public ExperienceType getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(ExperienceType experienceType) {
        this.experienceType = experienceType;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Experience() {
        super();
    }
}

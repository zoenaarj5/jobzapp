package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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
    @Column(name="START_DATE")
    protected LocalDate startDate;
    @Column(name="END_DATE")
    protected LocalDate endDate;
    @Transient
    protected float duration;

    public Experience(Person person, Organization organization, ExperienceType experienceType,LocalDate startDate,LocalDate endDate) {
        this.person = person;
        this.organization = organization;
        this.experienceType = experienceType;
        this.startDate=startDate;
        this.endDate=endDate;
        updateDuration();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        updateDuration();
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        updateDuration();
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
    protected void updateDuration(){
        this.duration=(startDate==null||endDate==null)? null:Period.between(startDate,endDate).getMonths()/12;
    }
}

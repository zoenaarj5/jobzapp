package org.kavus.jobzapp.entity;

import javax.persistence.*;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @ManyToOne
    @JoinColumn(name="APPLICANT_ID")
    protected Person applicant;
    @ManyToOne
    @JoinColumn(name="JOB_ID")
    protected Job job;

    public Application(Person applicant, Job job) {
        super();
        this.applicant = applicant;
        this.job = job;
    }

    public Application() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Person getApplicant() {
        return applicant;
    }

    public void setApplicant(Person applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}

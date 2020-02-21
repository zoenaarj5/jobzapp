package org.kavus.jobzapp.entity;

import javax.persistence.Entity;

@Entity
public class PhoneContact extends Contact {
    protected String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

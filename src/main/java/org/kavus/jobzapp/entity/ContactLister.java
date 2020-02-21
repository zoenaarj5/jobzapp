package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ContactLister {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Set<Contact> getContactSet() {
        return contactSet;
    }

    public void setContactSet(Set<Contact> contactSet) {
        this.contactSet = contactSet;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "CONTACT_LISTER_ID")
    private Set<Contact> contactSet;
}

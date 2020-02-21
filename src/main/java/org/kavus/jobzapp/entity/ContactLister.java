package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.List;
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

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @OneToMany
    @JoinColumn(name = "CONTACT_LISTER_ID")
    private List<Contact> contactList;
}

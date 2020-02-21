package org.kavus.jobzapp.entity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContactTypeCode getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(ContactTypeCode typeCode) {
        this.typeCode = typeCode;
    }
    public Contact(){
        super();
    }
    @Enumerated(EnumType.STRING)
    protected ContactTypeCode typeCode;
}

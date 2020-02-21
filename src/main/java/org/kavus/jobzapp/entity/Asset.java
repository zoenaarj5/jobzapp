package org.kavus.jobzapp.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Asset {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Asset() {
        super();
    }

    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
}

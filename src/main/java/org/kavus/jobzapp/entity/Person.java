package org.kavus.jobzapp.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name="userName",column = @Column(name="USER_NAME",unique = true)),
            @AttributeOverride(name="email",column = @Column(name="EMAIL",unique = true)),
            @AttributeOverride(name="password",column = @Column(name="PASSWORD"))
    })
    protected LoginData loginData;
    @Embedded
    @AttributeOverrides(value={
        @AttributeOverride(name="firstName",column = @Column(name="FIRST_NAME")),
        @AttributeOverride(name="lastName",column = @Column(name="LAST_NAME")),
        @AttributeOverride(name="birthDate",column = @Column(name="BIRTH_DATE")),
        @AttributeOverride(name="sex",column = @Column(name="SEX"))
    })
    protected PersonalData personalData;
    @ManyToMany
    @JoinTable(name="PERSON_HAS_ASSET")
    protected List<Asset> assetList;
    @OneToOne
    @JoinColumn(name="CONTACT_LISTER_ID")
    protected ContactLister contactLister;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginData loginData) {
        this.loginData = loginData;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public Person() {
        super();
    }

    public Person(LoginData loginData, PersonalData personalData) {
        this.loginData = loginData;
        this.personalData = personalData;
    }
}

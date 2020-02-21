package org.kavus.jobzapp.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Definition {
    protected static LanguageCode currentLanguageCode;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    public Definition(Definable definable, LanguageCode languageCode) {
        this.definable = definable;
        this.languageCode = languageCode;
    }

    public Definition() {
        super();
    }

    public static LanguageCode getCurrentLanguageCode() {
        return currentLanguageCode;
    }

    public static void setCurrentLanguageCode(LanguageCode currentLanguageCode) {
        Definition.currentLanguageCode = currentLanguageCode;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Definable getDefinable() {
        return definable;
    }

    public void setDefinable(Definable definable) {
        this.definable = definable;
    }

    public LanguageCode getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(LanguageCode languageCode) {
        this.languageCode = languageCode;
    }

    @ManyToOne
    @JoinColumn(name = "DEFINABLE_ID")
    protected Definable definable;
    @Enumerated(EnumType.STRING)
    protected LanguageCode languageCode;
}

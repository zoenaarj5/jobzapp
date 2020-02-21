package org.kavus.jobzapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

@Entity
public class LDefinition extends Definition{
    @Length(max=150)
    protected String title;
    @Length(max=350)
    protected String intro;
    @Length(max=1000)
    protected String body;

    public LDefinition(Definable definable, LanguageCode languageCode, @Length(max = 150) String title, @Length(max = 350) String intro, @Length(max = 1000) String body) {
        super(definable, languageCode);
        this.title = title;
        this.intro = intro;
        this.body = body;
    }

    public LDefinition(@Length(max = 150) String title, @Length(max = 350) String intro, @Length(max = 1000) String body) {
        this.title = title;
        this.intro = intro;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

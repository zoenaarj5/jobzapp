package org.kavus.jobzapp.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;

@Entity
public class XLDefinition extends Definition{
    @Length(max=200)
    protected String title;
    @Length(max=500)
    protected String intro;

    public XLDefinition(Definable definable, LanguageCode languageCode, @Length(max = 200) String title, @Length(max = 500) String intro, @Length(max = 1500) String body) {
        super(definable, languageCode);
        this.title = title;
        this.intro = intro;
        this.body = body;
    }

    public XLDefinition(@Length(max = 200) String title, @Length(max = 500) String intro, @Length(max = 1500) String body) {
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

    @Length(max=1500)
    protected String body;
}

package org.kavus.jobzapp.entity;

import javax.persistence.Embeddable;

@Embeddable
public class LoginData {
    protected String userName;
    protected String email;
    protected String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginData() {
        super();
    }

    public LoginData(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}

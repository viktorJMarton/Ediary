package com.epam.ediary.domain;

import java.util.Objects;

public class Credentials {
    private String loginName;

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(loginName, that.loginName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginName, password);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Credentials() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

}

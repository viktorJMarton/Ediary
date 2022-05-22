package com.epam.ediary.domain;

import java.util.Objects;

public class User  {

    private long id;
    private String name;
    private Credentials credentials;

    public User() {
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(credentials, user.credentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, credentials);
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}

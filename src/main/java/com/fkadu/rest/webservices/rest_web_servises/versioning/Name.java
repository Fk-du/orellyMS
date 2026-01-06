package com.fkadu.rest.webservices.rest_web_servises.versioning;

public class Name {
    private String name;
    private String surname;
    public Name(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

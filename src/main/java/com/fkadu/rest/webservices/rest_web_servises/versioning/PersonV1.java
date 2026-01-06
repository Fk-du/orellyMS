package com.fkadu.rest.webservices.rest_web_servises.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}

package com.fkadu.rest.webservices.rest_web_servises.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"v1","v2"})
public class SomeBeen {
    private String v1;
    @JsonIgnore
    private String v2;
    private String v3;

    public SomeBeen(String v1, String v2, String v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public String getV3() {
        return v3;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }

    public String getV2() {
        return v2;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    @Override
    public String toString() {
        return "SomeBeen{" +
                "v1='" + v1 + '\'' +
                ", v2='" + v2 + '\'' +
                ", v3='" + v3 + '\'' +
                '}';
    }
}

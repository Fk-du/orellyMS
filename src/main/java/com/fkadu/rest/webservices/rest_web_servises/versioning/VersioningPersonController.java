package com.fkadu.rest.webservices.rest_web_servises.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("fkadu goitom");
    }

    @GetMapping("v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("fkadu","goitom"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonParam(){
        return new PersonV1("fkadu goitom");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonParam(){
        return new PersonV2(new Name("fkadu","goitom"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader(){
        return new PersonV1("fkadu goitom");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeader(){
        return new PersonV2(new Name("fkadu","goitom"));
    }
}

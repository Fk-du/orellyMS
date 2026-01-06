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

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader(){
        return new PersonV1("fkadu goitom");
    }

    //header = X-API-VERSION value= 2
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeader(){
        return new PersonV2(new Name("fkadu","goitom"));
    }

    //header = accept value= Application/vnd.company.app-v1+json
    @GetMapping(path = "/person/accept", produces = "Application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("fkadu goitom");
    }

    @GetMapping(path = "/person/accept", produces = "Application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("fkadu","goitom"));
    }
}

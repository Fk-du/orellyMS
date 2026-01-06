package com.fkadu.rest.webservices.rest_web_servises.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public SomeBeen filtering(){
        return new SomeBeen("v1", "v2","vs");
    }

    @GetMapping("/filtering/list")
    public List<SomeBeen> filteringList(){
        return Arrays.asList(new SomeBeen("v1", "v2","v3"),
                new SomeBeen("v4", "v5","v6"),
                new SomeBeen("v7", "v8","v9")
                );
    }
}

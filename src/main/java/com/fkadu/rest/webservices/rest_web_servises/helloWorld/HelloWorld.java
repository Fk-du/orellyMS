package com.fkadu.rest.webservices.rest_web_servises.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

    private MessageSource messageSource;
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("hello-world-been")
    public HelloWorldBeen helloWorldBeen() {
        return new  HelloWorldBeen("Hello World Been");
    }

    @GetMapping("hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();

        return messageSource.getMessage("good.morning.message",
                null, "default message",locale);


    }


}

package com.edudev.multitenant.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteResource {

    @GetMapping
    public String sayHello() {
        return "Hello from Multi Tenant";
    }


}

package com.edudev.hateoas.layer0;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceResource {

    @PostMapping
    public ResponseEntity<Object> service(@RequestBody final String method) {
        return switch (method) {
            case "TEST_METHOD" -> ResponseEntity.ok(method);
            case "METHOD_1" -> ResponseEntity.ok("METHOD 1 RETURN");
            case "METHOD_2" -> ResponseEntity.ok("METHOD 2 RETURN");
            default -> ResponseEntity.ok(null);
        };
    }
}

package com.simple.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsecureController {

    @GetMapping(value = "/public", produces = MediaType.TEXT_PLAIN_VALUE)
    public String get() {
        return "Unsecure content!";
    }
}

package com.example.hosptal.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping(value = "/notAuthorized")
    public String notAuthorized(){
        return "403";
    }
}

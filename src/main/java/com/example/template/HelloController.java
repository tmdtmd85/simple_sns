package com.example.template;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/tom")
    public String tom() {
        return "template";
    }
}

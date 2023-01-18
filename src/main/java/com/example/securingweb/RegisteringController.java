package com.example.securingweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisteringController {

  @GetMapping("/register")
  public String registeringForm(Model model) {
    model.addAttribute("registering", new Registering());
    return "register";
  }

  @PostMapping("/register")
  public String greetingSubmit(@ModelAttribute Registering registering, Model model) {
    model.addAttribute("registering", registering);
    return "result_register";
  }
}
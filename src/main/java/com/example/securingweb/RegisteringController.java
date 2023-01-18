package com.example.securingweb;

import java.util.ArrayList;
import java.util.List;

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
    List<Integer> IntegerList = new ArrayList<>();
    for(int i = 2023; i >= 1905; i--) {
    	IntegerList.add(i);
    }
    List<Integer> MonthList = new ArrayList<>();
    for(int i = 1; i <= 12; i++) {
    	MonthList.add(i);
    }
    List<Integer> DayList = new ArrayList<>();
    for(int i = 1; i <= 31; i++) {
    	DayList.add(i);
    }
    model.addAttribute("IntegerList", IntegerList);
    model.addAttribute("MonthList", MonthList);
    model.addAttribute("DayList", DayList);
    return "register";
  }

  @PostMapping("/register")
  public String greetingSubmit(@ModelAttribute Registering registering, Model model) {
    model.addAttribute("registering", registering);
    return "result_register";
  }
}
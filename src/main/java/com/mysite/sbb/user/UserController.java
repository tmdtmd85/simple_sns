package com.mysite.sbb.user;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	private final RegisteringService registeringService;
	
	@GetMapping("/signup")
	public String signup(Model model, Registering registering) {
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
		
		return "signup_form";
	}
	
    @PostMapping("/signup")
    public String signup(@Valid Registering registering, BindingResult bindingResult) {
        registeringService.create(registering.getSurname(), 
    			registering.getName(),
    			registering.getUsername(),
    			registering.getPassword(),
    			registering.getYear(),
    			registering.getMonth(),
    			registering.getDay(),
    			registering.getGender());
        
        return "redirect:/hello";
    }
    
    @GetMapping("/login")
    public String login(Model model, Registering registering) {
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
    	
        return "login";
    }
    
}

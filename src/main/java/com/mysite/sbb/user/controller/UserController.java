package com.mysite.sbb.user.controller;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.mysite.sbb.user.database.registering.*;
import com.mysite.sbb.user.database.comment.*;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final RegisteringService registeringService;
	private final CommentService commentService;
	
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
    	
        Registering n = registeringService.create(registering.getSurname(), 
    			registering.getName(),
    			registering.getUsername(),
    			registering.getPassword(),
    			registering.getYear(),
    			registering.getMonth(),
    			registering.getDay(),
    			registering.getGender()
    		);
        
        String folder = "C:/Users/tmdtm/OneDrive/바탕 화면/sns/src/main/resources/static/";
        
		String path = folder + n.getId().toString();
        File f1 = new File(path);    
        boolean bool1 = f1.mkdir();
        
        path = folder + n.getId().toString() + "/comment";
        File f2 = new File(path);    
        boolean bool2 = f2.mkdir(); 
        
        path = folder + n.getId().toString() + "/profile";
        File f3 = new File(path);    
        boolean bool3 = f3.mkdir(); 
        
        
        Comment c = commentService.create(
        		n.getId(),
        		n.getYear()+"년 "+n.getMonth()+"월 "+n.getDay()+"일 출생", 
        		"./common/born.png"
        	);
        
        return "redirect:/main";
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

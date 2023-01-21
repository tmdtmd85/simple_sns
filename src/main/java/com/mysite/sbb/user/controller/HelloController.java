package com.mysite.sbb.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.sbb.user.database.comment.*;
import com.mysite.sbb.user.database.registering.*;


@RequiredArgsConstructor
@Controller
public class HelloController {
	@Autowired
	private final CommentRepository commentRepository;
	private final RegisteringRepository registeringRepository;
	
    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	
    	model.addAttribute("registering", registering);
    	
    	List<Comment> CommentList = commentRepository.findAll();
    	
    	model.addAttribute("CommentList", CommentList);
    	
        return "main";
    }
    
    @GetMapping(path="/profile")
    public String profile(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	List<Comment> CommentList = commentRepository.findAll();
    	model.addAttribute("CommentList", CommentList);
    	model.addAttribute("registering", registering);
    	model.addAttribute("profile", registering);
    	return "profile";
    }

    
    @GetMapping(path="/ex")
    public String profilebyid(Model model, @RequestParam(value = "id")Long id, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Optional<Registering> optional_registering = registeringRepository.findById(id);
    	Registering registering = optional_registering.get();
    	model.addAttribute("profile", registering);
    	registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	return "profile";
    }
    
    
    @GetMapping(path="/search")
    public String search(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	List<Registering> registerings = registeringRepository.findAll();
    	model.addAttribute("registeringList", registerings);
    	
    	Registering registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	return "search";
    }
    
    @GetMapping(path="/tom")
    public String tom(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	return "home";
    }
}
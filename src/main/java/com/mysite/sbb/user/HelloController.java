package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.ResponseBody;



@RequiredArgsConstructor
@Controller
public class HelloController {
	@Autowired
	private final CommentRepository commentRepository;
    @GetMapping("/hello")
    public String hello(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	
    	model.addAttribute("registering", registering);
    	
    	List<Comment> CommentList = commentRepository.findAll();
    	
    	model.addAttribute("CommentList", CommentList);
    	
        return "main";
    }
    
    
    @GetMapping(path="/hello/all")
    public @ResponseBody Integer getAllUsers() {
    	return commentRepository.findAll().get(0).getId();
    }
    
    @GetMapping(path="/yo")
    public String authenticationKeyCheck(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	return "fortfolio";
    }
    
    @GetMapping(path="/ex")
    public String cat(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	List<Comment> CommentList = commentRepository.findAll();
    	model.addAttribute("CommentList", CommentList);
    	model.addAttribute("registering", registering);
    	return "profile";
    }
}
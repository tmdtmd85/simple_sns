package com.mysite.sbb.user.controller;

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

import com.mysite.sbb.user.database.comment.*;
import com.mysite.sbb.user.database.registering.*;


@RequiredArgsConstructor
@Controller
public class HelloController {
	@Autowired
	private final CommentRepository commentRepository;
    @GetMapping("/main")
    public String hello(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	
    	model.addAttribute("registering", registering);
    	
    	List<Comment> CommentList = commentRepository.findAll();
    	
    	model.addAttribute("CommentList", CommentList);
    	
        return "main";
    }
    
    @GetMapping(path="/profile")
    public String cat(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	List<Comment> CommentList = commentRepository.findAll();
    	model.addAttribute("CommentList", CommentList);
    	model.addAttribute("registering", registering);
    	return "profile";
    }
}
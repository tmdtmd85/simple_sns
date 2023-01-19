package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.securingweb.Registering;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.ResponseBody;



@RequiredArgsConstructor
@Controller
public class HelloController {
	@Autowired
	private final CommentRepository commentRepository;
    @GetMapping("/hello")
    public String hello(Model model) {
    	
    	List<String> StringList = new ArrayList<>();
    	StringList.add("A");
    	StringList.add("B");
    	StringList.add("C");
    	StringList.add("D");
    	StringList.add("E");
    	model.addAttribute("StringList", StringList);
    	
    	List<Comment> CommentList = commentRepository.findAll();
    	model.addAttribute("CommentList", CommentList);
    	
        return "main";
    }
    @GetMapping(path="/hello/all")
    public @ResponseBody Integer getAllUsers() {
    	return commentRepository.findAll().get(0).getId();
    }
}
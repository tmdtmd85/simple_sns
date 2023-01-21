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
import com.mysite.sbb.user.database.friend.*;
import com.user.sbb.user.message.*;

@RequiredArgsConstructor
@Controller
public class HelloController {
	@Autowired
	private final CommentRepository commentRepository;
	private final RegisteringRepository registeringRepository;
	private final FriendRepository friendRepository;
	
    @GetMapping("/main")
    public String main(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	
    	model.addAttribute("registering", registering);
    	
    	List<Comment> CommentList = commentRepository.findByUserid(registering.getId());
    	
    	model.addAttribute("CommentList", CommentList);
    	
    	messagelist(model, registering);
    	
        return "main";
    }
    
    @GetMapping(path="/ex")
    public String profilebyid(Model model, @RequestParam(value = "id")Integer id, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Optional<Registering> optional_profile = registeringRepository.findById(id);
    	
    	Registering profile = optional_profile.get();
    	model.addAttribute("profile", profile);
    	
    	Registering registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	
    	List<Comment> CommentList = commentRepository.findByUserid(id);
    	model.addAttribute("CommentList", CommentList);
    	
    	model.addAttribute("authenticated", profile.getId().equals(registering.getId()));
    	
    	messagelist(model, registering);
    	
    	return "profile";
    }
    
    
    @GetMapping(path="/search")
    public String search(Model model, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	List<Registering> registerings = registeringRepository.findAll();
    	model.addAttribute("registeringList", registerings);
    	
    	Registering registering = registeringAdapter.getRegistering();
    	model.addAttribute("registering", registering);
    	
    	messagelist(model, registering);
    	
    	return "search";
    }
    
    private void messagelist(Model model, Registering registering) {
    	List<Message> messageList = new ArrayList<Message>();
		
    	Registering sendregistering;
    	
    	Message message = new Message();
    	
    	for(Friend friend : friendRepository.findByDestidAndApproval(registering.getId(), false)) {
    		sendregistering = registeringRepository.findById(friend.getSendid()).get();
    		message = new Message();
    		message.setRegistering(sendregistering);
    		messageList.add(message);
    	}
    	
    	model.addAttribute("MessageList", messageList);
    }
}

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

@RequiredArgsConstructor
@Controller
public class FriendController {
	@Autowired
	private final CommentRepository commentRepository;
	private final RegisteringRepository registeringRepository;
	private final FriendRepository friendRepository;
	private final FriendService friendService;
	
    @GetMapping("/addfriend")
    public @ResponseBody List<Friend> addfriend(@RequestParam(value = "destid")Integer destid, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
    	Registering registering = registeringAdapter.getRegistering();
    	
    	friendService.create(registering.getId(), destid);
    	
    	
        return friendRepository.findAll();
    }
}
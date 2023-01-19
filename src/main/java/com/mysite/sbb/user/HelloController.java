package com.mysite.sbb.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
    	
    	List<String> StringList = new ArrayList<>();
    	StringList.add("A");
    	StringList.add("B");
    	StringList.add("C");
    	StringList.add("D");
    	StringList.add("E");
    	model.addAttribute("StringList", StringList);
    	
        return "main";
    }
}
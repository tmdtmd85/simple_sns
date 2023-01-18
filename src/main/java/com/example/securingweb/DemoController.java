package com.example.securingweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/loop")
    public String loop(Model model) {
        List<Integer> IntegerList = new ArrayList<>();
        IntegerList.add(1);
        IntegerList.add(2);
        IntegerList.add(3);
        model.addAttribute("IntegerList", IntegerList);
        return "loop";
    }
}
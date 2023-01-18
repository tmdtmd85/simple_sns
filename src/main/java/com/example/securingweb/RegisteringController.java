package com.example.securingweb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisteringController {

  @GetMapping("/login")
  public String registeringForm(Model model) {
    model.addAttribute("registering", new Registering());
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

  @PostMapping("/add")
  public String greetingSubmit(@ModelAttribute Registering registering, Model model) {
    model.addAttribute("registering", registering);
    return "result_register";
  }
  
  @Autowired
  private RegisteringRepository RegisteringRepository;
	
  @PostMapping(path="/register")
  public @ResponseBody String addNewUser(
		  @RequestParam String surname,
		  @RequestParam String name,
		  @RequestParam String teloremail,
		  @RequestParam String password,
		  @RequestParam String year,
		  @RequestParam String month,
		  @RequestParam String day,
		  @RequestParam String gender
		  ) {
	  Registering n = new Registering();
	  n.setSurname(surname);
	  n.setName(name);
	  n.setTeloremail(teloremail);
	  n.setPassword(password);
	  n.setYear(year);
	  n.setMonth(month);
	  n.setDay(day);
	  n.setGender(gender);
	  RegisteringRepository.save(n);
	  return "Saved";
  }
  @GetMapping(path="/register/all")
  public @ResponseBody Iterable<Registering> getAllUsers() {
	 return RegisteringRepository.findAll();
  }
  
  
}
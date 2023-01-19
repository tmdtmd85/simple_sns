package com.mysite.sbb.user;

import java.nio.file.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;


import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {
	@PostMapping("/image")
	public @ResponseBody String image(MultipartFile pic, String text) {
		String imageFileName = pic.getOriginalFilename();
		
		String path = "C:/Users/tmdtm/OneDrive/바탕 화면/sns/src/main/resources/static/";
		
		Path imagePath = Paths.get(path + imageFileName);
		
		try {
			Files.write(imagePath, pic.getBytes());
		} catch(Exception e) {
		}
		
		return text;
	}
	
	@GetMapping("/image")
	public String greetingSubmit() {
	    return "uploadForm";
	}

}

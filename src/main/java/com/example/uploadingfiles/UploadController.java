package com.example.uploadingfiles;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.example.securingweb.Greeting;

import org.springframework.web.bind.annotation.ResponseBody;

public class UploadController {
	@PostMapping("/image")
	public @ResponseBody String image(MultipartFile pic) {
		return "abc";
	}
	
	@GetMapping("/image")
	public String greetingSubmit() {
	    return "uploadForm";
	}

}

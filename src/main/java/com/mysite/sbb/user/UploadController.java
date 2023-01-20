package com.mysite.sbb.user;

import java.nio.file.*;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.ResponseBody;



@RequiredArgsConstructor
@Controller
public class UploadController {
	private final CommentService commentService;
	private final RegisteringService registeringService;
	
	@PostMapping("/image")
	public @ResponseBody String image(MultipartFile pic, String text, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
		String imageFileName = pic.getOriginalFilename();
		
		Registering registering = registeringAdapter.getRegistering();
		
        commentService.create(Integer.valueOf(1),
	    			text,
	    			"./" + registering.getId().toString() + "/comment/" + imageFileName
    			);	
        
		String path = "C:/Users/tmdtm/OneDrive/바탕 화면/sns/src/main/resources/static/"+registering.getId().toString()+"/comment/";
		
		Path imagePath = Paths.get(path + imageFileName);
		
		try {
			Files.write(imagePath, pic.getBytes());
		} catch(Exception e) {
		}
		
		return imagePath.toString();
	}
	
	@GetMapping("/image")
	public String greetingSubmit() {
	    return "uploadForm";
	}
	
    @PostMapping(path="/background")
    public @ResponseBody String dog(MultipartFile pic, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
		String imageFileName = pic.getOriginalFilename();
		
		Registering registering = registeringAdapter.getRegistering();
		
		registering.setBackground("./" + registering.getId().toString() + "/profile/background.jpg");		
		
		registeringService.changeBackground(registering.getId(), registering.getBackground());
        
		String path = "C:/Users/tmdtm/OneDrive/바탕 화면/sns/src/main/resources/static/"+registering.getId().toString()+"/profile/background.jpg";
		
		Path imagePath = Paths.get(path);
		
		try {
			Files.deleteIfExists(imagePath);
			Files.write(imagePath, pic.getBytes());
		} catch(Exception e) {
		}
		
		return "./" + registering.getId().toString() + "/profile/background.jpg";
    }
    
    @PostMapping(path="/updateprofile")
    public @ResponseBody String duck(MultipartFile pic, @AuthenticationPrincipal RegisteringAdapter registeringAdapter) {
		String imageFileName = pic.getOriginalFilename();
		
		Registering registering = registeringAdapter.getRegistering();
		
		registering.setProfile("./" + registering.getId().toString() + "/profile/profile.jpg");		
	
		
		registeringService.changeProfile(registering.getId(), registering.getProfile());
        
		String path = "C:/Users/tmdtm/OneDrive/바탕 화면/sns/src/main/resources/static/"+registering.getId().toString()+"/profile/profile.jpg";
		
		Path imagePath = Paths.get(path);
		
		try {
			Files.deleteIfExists(imagePath);
			Files.write(imagePath, pic.getBytes());
		} catch(Exception e) {
		}
		
		return "./" + registering.getId().toString() + "/profile/profile.jpg";
    }

}

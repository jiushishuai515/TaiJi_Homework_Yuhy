package com.taiji.yuhongyue.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadFileController {
	
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		File localFile = new File("D://springboot_upload/"+file.getOriginalFilename());
		file.transferTo(localFile);
		return "success";
		
	}
	
	@GetMapping("up")
	public String up() {
		return "up";
	}

}

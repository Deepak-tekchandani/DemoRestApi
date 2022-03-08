package com.apibook.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam ("file") MultipartFile file){
		
		System.out.println("Original name : "+file.getOriginalFilename());
		System.out.println(" Size : "+file.getSize());
		System.out.println(" Type : "+file.getContentType());
		System.out.println("Name : "+file.getName());
		return ResponseEntity.ok("Working");
	}

}

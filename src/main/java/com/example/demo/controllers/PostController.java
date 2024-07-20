package com.example.demo.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/posts")
public class PostController {
	
	
	
	@RequestMapping("/list")
	public String list(){
		
		return null;
		
	}
	
	@RequestMapping("/drafts")
	public String drafts(){
		
		return "view drafts....";
	}
	
	@RequestMapping("/add")
	public String addpost(){
		
		return "add posts....";
	}

}

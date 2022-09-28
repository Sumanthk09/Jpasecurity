package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dbsusercontroller 
{
	@GetMapping("/home")
	public String page1()
	{
		return "This is homepage";
	}
	@GetMapping("/user")
	public String page2()
	{
		return "This is userpage";
	}
	@GetMapping("/admin")
	public String page3()
	{
		return "This is adminpage";
	}
}

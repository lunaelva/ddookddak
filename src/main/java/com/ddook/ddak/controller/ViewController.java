package com.ddook.ddak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("/article/write")
	public String write(Model model) {
		model.addAttribute("name","자게이");
		return "write";
	}
	
}

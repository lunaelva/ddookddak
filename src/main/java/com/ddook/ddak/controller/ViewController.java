package com.ddook.ddak.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {
	
	@RequestMapping("/board/write")
	public String write(Model model) {
		Date date = new Date();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyMMdd");
		System.out.println(sf.format(date));
		model.addAttribute("name","자게이");
		return "write";
	}
	
}

package com.ddook.ddak.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("name","자게");
		return "index";
	}
	@RequestMapping("/view/article/{type}")
	public String write(Model model, @PathVariable("type") String type) {
		model.addAttribute("name","자게");
		model.addAttribute("articleId",0);
		if(type.equals("update")) type = "write";
		return "articles/" + type;
	}
	
	@RequestMapping("/view/article/{type}/{articleId}")
	public String view(Model model, @PathVariable("type") String type, @PathVariable("articleId") Long articleId) {
		model.addAttribute("name","자게");
		model.addAttribute("articleId",articleId);
		if(type.equals("update")) type = "write";
		return "articles/" + type;
	}

	@RequestMapping("/view/board/")
	public String boards(){
		return "boards/board";
	}
	
}

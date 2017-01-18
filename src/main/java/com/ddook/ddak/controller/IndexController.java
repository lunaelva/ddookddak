package com.ddook.ddak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddook.ddak.service.ArticleService;

@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	private ArticleService articleService;
	
	public String list(Model model) {
		return "index";
	}
}

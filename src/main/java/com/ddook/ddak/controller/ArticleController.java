package com.ddook.ddak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/list")
	public List<Articles> list(Model model) {
		List<Articles> articleList = articleService.findArticles();
		return articleList;
	}
	
	@RequestMapping("/write/view")
	public String write(Model model) {
		model.addAttribute("name","자게이");
		return "write";
	}
	
	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}

}

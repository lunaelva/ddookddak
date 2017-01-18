package com.ddook.ddak.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ddook.ddak.model.Articles;
import com.ddook.ddak.service.ArticleService;
/**
 * ariticle 
 * @author lunamaan
 *
 */
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
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public ModelAndView writeProc(HttpServletRequest request, @RequestParam Map<String, String> param){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("json");	
		if(articleService.saveArticles(param)){
			mav.addObject("result", "success");
		}else{
			mav.addObject("result", "fail");
		}
		return mav;
	}
	
	@RequestMapping("/test")
	public String test() {
		return "Hello World";
	}

}

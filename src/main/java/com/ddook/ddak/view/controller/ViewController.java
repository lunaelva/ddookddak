package com.ddook.ddak.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ddook.ddak.board.component.BoardInfoComponent;
import com.ddook.ddak.board.model.BoardModel;

@Controller
@RequestMapping("/view")
public class ViewController {

	@RequestMapping("/a")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","자게");
		mav.setViewName("index");
		return mav;
	}
	
	
//	
//	@RequestMapping("/article/{boardName}/{type}")
//	public String write(Model model, @PathVariable("boardName") String boardReqName, @PathVariable("type") String type) {
//		BoardModel boardInfo = BoardInfoComponent.getBoardInfo(boardReqName);
//		
//		model.addAttribute("boardInfo", boardInfo);
//		model.addAttribute("articleId",0);
//		if(type.equals("update")) type = "write";
//		return "articles/" + type;
//	}
//	
//	@RequestMapping("/article/{type}/{articleId}")
//	public String view(Model model, @PathVariable("type") String type, @PathVariable("articleId") Long articleId) {
//		model.addAttribute("name","자게");
//		model.addAttribute("articleId",articleId);
//		if(type.equals("update")) type = "write";
//		return "articles/" + type;
//	}
//
	@RequestMapping("/board")
	public String boards(Model model){
		return "boards/board";
	}
	
	
}

package com.ddook.ddak.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddook.ddak.board.component.BoardInfoComponent;
import com.ddook.ddak.board.entity.Article;
import com.ddook.ddak.board.entity.BoardCategories;
import com.ddook.ddak.board.model.BoardModel;
import com.ddook.ddak.board.service.ArticleService;
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
	
	@RequestMapping("/{boardName}")
	public String list(Model model, @PathVariable("boardName") String boardReqName) {
		BoardModel boardInfo = BoardInfoComponent.getBoardInfo(boardReqName);
		
		if(boardInfo == null){
			return "error";
		}
			
		
		List<BoardCategories> categories= boardInfo.getCategory();
		System.out.println(categories.toString());
	
		model.addAttribute("boardInfo", boardInfo);
		model.addAttribute("cateInfo", categories);
		model.addAttribute("articleId",0);
		return "articles/" + boardReqName + "/list";
	}

//	@ResponseBody
//	@RequestMapping("/list") 
//	public Page<Article> list(Model model) {		
//		PageRequest pageRequest = new PageRequest(0, 10, new Sort(Direction.DESC, "articleId")); //현재페이지, 조회할 페이지수, 정렬정보
//		return articleService.findArticles(pageRequest);
//	}
//
//	@ResponseBody
//	@RequestMapping(value="/save", method=RequestMethod.POST)
//	public void writeProc(@RequestParam Map<String, String> param, Model model){
//		articleService.saveArticle(param);
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/{articleId}", method=RequestMethod.DELETE)
//	public void delProc(@RequestParam Map<String, String> param, Model model){
//		articleService.saveArticle(param);
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/{articleId}", method=RequestMethod.PUT)
//	public void updateProc(@RequestParam Map<String, String> param, Model model){
//		articleService.saveArticle(param);
//	}
//	
//	@ResponseBody
//	@RequestMapping(value="/{articleId}", method=RequestMethod.GET)
//	public Article viewProc(@PathVariable("articleId") int articleId){
//		return articleService.getArticle(articleId);
//	}

}

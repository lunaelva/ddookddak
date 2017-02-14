package com.ddook.ddak.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddook.ddak.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@ResponseBody
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public void createBoard(@RequestParam Map<String, String> param){
		System.out.println(param.get("pageLimit"));
		System.out.println(param.toString());
		boardService.saveBoard(param);		
	}
}

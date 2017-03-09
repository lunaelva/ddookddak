package com.ddook.ddak.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddook.ddak.board.model.Board;
import com.ddook.ddak.board.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@ResponseBody
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public void createBoard(@RequestParam Map<String, String> param){
		boardService.saveBoard(param);		
	}
	
	@ResponseBody
	@PostMapping(value="/update")
	public int updateBoard(@RequestParam Map<String, String> param){
		return boardService.updateBoard(param);
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Board> boardList(){
		return boardService.findBoards();
	}

	@ResponseBody	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public Board getBoard(@RequestParam("boardId") int boardId){
		Board b = boardService.getBoard(boardId);
		return     b;
	}
//	@ResponseBody
//	@RequestMapping(value="/addcategory", method=RequestMethod.POST)
//	public void addCategory(@RequestParam Map<String, String> param){
//		boardService.saveBoardCategory(param);
//	}
	
//	@ResponseBody
//	@RequestMapping(value="/category")
//	public List<BoardCategory> addCategory(@RequestParam("boardId") int boardId){
//		return boardService.getBoardCategory(boardId);
//	}
}

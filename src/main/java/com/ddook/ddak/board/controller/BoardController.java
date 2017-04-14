package com.ddook.ddak.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ddook.ddak.board.entity.Boards;
import com.ddook.ddak.board.model.BoardModel;
import com.ddook.ddak.board.service.BoardService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
@RequestMapping("/board")
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@Autowired 
	private CacheManager cacheManager;
	
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
	public List<JSONObject> boardList(Model model){
		Cache cache = cacheManager.getCache("boardConfig");
		System.out.println( cache.getKeys().size());
		
		
		List<Boards> boards = boardService.findBoards();
		
		List<JSONObject> boardList = new ArrayList<>();
		
		for(Boards b : boards){	
			
			JSONParser jsonParser = new JSONParser();
			String jsonSt = "";
			JSONObject jsonObj = null;
			try {
				jsonObj = (JSONObject)jsonParser.parse(b.getBoardAttr());
				jsonSt = jsonObj.toJSONString();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			boardList.add(jsonObj);
		}
		
		
		return boardList;
	}

	@ResponseBody	
	@RequestMapping(value="/view/{name}", method=RequestMethod.GET)
	public Boards getBoard(@PathVariable("name") String boardName){
		Boards b = boardService.getBoardByName(boardName);
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

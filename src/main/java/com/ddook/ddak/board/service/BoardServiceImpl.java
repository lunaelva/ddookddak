package com.ddook.ddak.board.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.entity.BoardCategories;
import com.ddook.ddak.board.entity.Boards;
import com.ddook.ddak.board.repository.BoardCategoryRepository;
import com.ddook.ddak.board.repository.BoardsRepository;

@Service("boardService")
@Transactional
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardsRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	
	@Override
	public List<Boards> findBoards(){
		return boardRepository.findAll();
	}
	
	@Override
	@Cacheable(value="boardConfig", key="#name")
	public List<Boards> findBoardsForCache(String name){
		return boardRepository.findAll();
	}

	@Override
	public void saveBoard(Map<String, String> param){
		System.out.println(param.toString());
		
		int boardId = param.get("boardId") != null ?Integer.parseInt(param.get("boardId")) : 0;
		String boardName = param.get("boardName") != null ?param.get("boardName") : "";
				
		JSONObject jsonObj = new JSONObject();
		for( String key : param.keySet() ){
			jsonObj.put(key, param.get(key));
        }
		
		
		String jsonSt = jsonObj.toJSONString();

//		StringBuffer sb = new StringBuffer();
//		
//		Board board = new Board( Integer.parseInt(param.get("boardId")), param.get("boardName"), param.get("boardKorName"), Integer.parseInt(param.get("boardType")), param.get("hidden"), param.get("commentUse")
//				, Integer.parseInt(param.get("pageLimit")), param.get("recommUse"), param.get("reportUse")
//				, param.get("imageAddUse"), param.get("mediaAddUse"),0
//				, 0, 0, 0, Integer.parseInt(param.get("commentMaxCnt")),0,0,0,0,0);
//		return boardRepository.save(board).getBoardId();
//		
		
//		Boards board = new Boards( boardId,boardName "default", jsonSt);
		
//		boardRepository.save(board);
	}
	
	@Override
	public Boards getBoard(int boardId){
		Boards b =  boardRepository.findOne(boardId);
		return b;
	}
	
	@Override
	public Boards getBoardByName(String name){
		Boards b =  boardRepository.findByBoardName(name);
		b.getBoardName();
		return b;
	}
	
	
	@Override
	public void deleteBaord(int boardId){
		boardRepository.delete(boardId);
	}
	
	@Override
	public int updateBoard(Map<String, String> param){
		Boards board = new Boards( Integer.parseInt(param.get("boardId")), param.get("boardValue"), null);
		return boardRepository.save(board).getBoardId();
	}
	
//	@Override
//	public void saveBoardCategory(Map<String, String> param){
//		int boardId = Integer.parseInt(param.get("boardId"));
//		Board board = new Board();
//		board.setBoardId(boardId);
//		
//		BoardCategory boardCategory = new BoardCategory(0
//				, board
//				, param.get("hidden")
//				, param.get("cateName")
//				, Integer.parseInt(param.get("sort")));
//		
//		boardCategoryRepository.save(boardCategory);
//	}
	
	@Override
	public List<BoardCategories> findBoardCategories(){
		return boardCategoryRepository.findAll();
	}
}

package com.ddook.ddak.board.service;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.model.Board;
import com.ddook.ddak.board.model.BoardCategory;
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
	public List<Board> findBoards(){
		return boardRepository.findAll();
	}

	@Override
	public void saveBoard(Map<String, String> param){
		System.out.println(param.toString());
		Board board = new Board(0, param.get("boardName")
				, param.get("boardKorName")
				, Integer.parseInt(param.get("boardType"))
				, param.get("hidden")
				, param.get("commentUse")
				, Integer.parseInt(param.get("pageLimit"))
				, param.get("recommUse")
				, param.get("reportUse")
				, param.get("imageAddUse")
				, param.get("mediaAddUse")
				,0 , 0, 0, 0
				, Integer.parseInt(param.get("commentMaxCnt"))
				,0,0,0,0,0);
		
		boardRepository.save(board);
	}
	
	@Override
	public Board getBoard(int boardId){
		return boardRepository.getOne(boardId);
	}
	
	@Override
	public void deleteBaord(int boardId){
		boardRepository.delete(boardId);
	}
	
	@Override
	public int updateBoard(Map<String, String> param){
		Board board = new Board( Integer.parseInt(param.get("boardId")), param.get("boardName"), param.get("boardKorName"), Integer.parseInt(param.get("boardType")), param.get("hidden"), param.get("commentUse")
				, Integer.parseInt(param.get("pageLimit")), param.get("recommUse"), param.get("reportUse")
				, param.get("imageAddUse"), param.get("mediaAddUse"),0
				, 0, 0, 0, Integer.parseInt(param.get("commentMaxCnt")),0,0,0,0,0);
		return boardRepository.save(board).getBoardId();
	}
	
	@Override
	public void saveBoardCategory(Map<String, String> param){
		int boardId = Integer.parseInt(param.get("boardId"));
		Board board = new Board();
		board.setBoardId(boardId);
		
		BoardCategory boardCategory = new BoardCategory(0
				, board
				, param.get("hidden")
				, param.get("cateName")
				, Integer.parseInt(param.get("sort")));
		
		boardCategoryRepository.save(boardCategory);
	}
	
	@Override
	public List<BoardCategory> getBoardCategory(int boardId){
		Board board = new Board();
		board.setBoardId(boardId);
		return boardCategoryRepository.findByBoard(board);
	}
}

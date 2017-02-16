package com.ddook.ddak.board.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.model.Board;
import com.ddook.ddak.board.model.BoardCategory;

@Service("boardService")
public interface BoardService {
	public List<Board> findBoards();	
	public void saveBoard(Map<String, String> param);
	public Board getBoard(int boardId);
	public void deleteBaord(int boardId);
	public int updateBoard(Map<String, String> param);
	
	public void saveBoardCategory(Map<String, String> param);
	public List<BoardCategory> getBoardCategory(int boardId);
}

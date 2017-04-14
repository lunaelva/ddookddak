package com.ddook.ddak.board.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.ddook.ddak.board.entity.BoardCategories;
import com.ddook.ddak.board.entity.Boards;

@Service("boardService")
public interface BoardService {
	public List<Boards> findBoards();	
	public void saveBoard(Map<String, String> param);
	public Boards getBoard(int boardId);
	public void deleteBaord(int boardId);
	public int updateBoard(Map<String, String> param);
	public Boards getBoardByName(String name);
	public List<Boards> findBoardsForCache(String name);
	List<BoardCategories> findBoardCategories();
	
//	public void saveBoardCategory(Map<String, String> param);
//	public List<BoardCategory> getBoardCategory(int boardId);
}

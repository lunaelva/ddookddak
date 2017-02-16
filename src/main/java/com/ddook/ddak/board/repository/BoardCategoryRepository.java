package com.ddook.ddak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.board.model.Board;
import com.ddook.ddak.board.model.BoardCategory;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory, Integer> {
	List<BoardCategory> findByBoard(Board board);
}

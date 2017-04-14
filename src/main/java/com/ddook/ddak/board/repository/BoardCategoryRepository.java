package com.ddook.ddak.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.board.entity.BoardCategories;

public interface BoardCategoryRepository extends JpaRepository<BoardCategories, Integer> {
	//List<BoardCategory> findByBoard(Board board);
}

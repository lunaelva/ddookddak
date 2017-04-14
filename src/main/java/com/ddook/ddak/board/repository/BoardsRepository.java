package com.ddook.ddak.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.board.entity.Boards;

public interface BoardsRepository extends JpaRepository<Boards, Integer> {
	public Boards findByBoardName(String boardName);
}

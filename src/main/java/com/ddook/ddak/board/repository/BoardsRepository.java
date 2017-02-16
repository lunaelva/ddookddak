package com.ddook.ddak.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ddook.ddak.board.model.Board;

public interface BoardsRepository extends JpaRepository<Board, Integer> {

}

package com.ddook.ddak.board.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoardCategory {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) 	
	private int cateId;
	@ManyToOne
	@JoinColumn(name="board_id")
	private Board board;
	private String hidden;
	private String cateName;
	private int sort;
	private LocalDateTime regDate;
	private LocalDateTime updDate;
	
	public BoardCategory(){}
	public BoardCategory(int cateId, Board board, String hidden, String cateName, int sort,
			LocalDateTime regDate, LocalDateTime updDate) {
		this.cateId = cateId;
		this.board = board;
		this.hidden = hidden;
		this.cateName = cateName;
		this.sort = sort;
		this.regDate = regDate;
		this.updDate = updDate;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public LocalDateTime getUpdDate() {
		return updDate;
	}
	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}
	

	
}

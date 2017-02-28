package com.ddook.ddak.board.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.ddook.ddak.common.audit.UserAuditable;
import com.ddook.ddak.common.handler.AuditableListener;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditableListener.class)
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.AUTO) 
	private int boardId;
	@Column(unique = true)
	private String boardName; //게시판 영문 이름
	private String boardKorName; //게시판 이름
	private String boardType; //게시판 타입
	private String hidden; //숨김여부
	private String commentUse; //댓글 유무
	private int pageLimit; //보여지는 게시글 수
	private String recommUse; //추천 유무
	private String reportUse; //신고 유무
	private String imageAddUse; //이미지 첨부 유무
	private String mediaAddUse; //외부 컨텐츠 유무
	private int coolTime; //글쓰기 쿨타임
	private int commentCoolTime; //댓글 쿨타임	 
	
	@Embedded
	protected UserAuditable auditable = new UserAuditable();
	
	@OneToMany(mappedBy = "board", orphanRemoval = true)
	@JsonIgnore
	private List<BoardCategory> category;
	
	public Board(){}
	
	public Board(int boardId, String boardName, String boardKorName, String boardType, String hidden,
			String commentUse, int pageLimit, String recommUse, String reportUse, String imageAddUse,
			String mediaAddUse, int coolTime, int commentCoolTime) {
		this.boardId = boardId;
		this.boardName = boardName;
		this.boardKorName = boardKorName;
		this.boardType = boardType;
		this.hidden = hidden;
		this.commentUse = commentUse;
		this.pageLimit = pageLimit;
		this.recommUse = recommUse;
		this.reportUse = reportUse;
		this.imageAddUse = imageAddUse;
		this.mediaAddUse = mediaAddUse;
		this.coolTime = coolTime;
		this.commentCoolTime = commentCoolTime;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardKorName() {
		return boardKorName;
	}
	public void setBoardKorName(String boardKorName) {
		this.boardKorName = boardKorName;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	public String getHidden() {
		return hidden;
	}
	public void setHidden(String hidden) {
		this.hidden = hidden;
	}
	public String getCommentUse() {
		return commentUse;
	}
	public void setCommentUse(String commentUse) {
		this.commentUse = commentUse;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}
	public String getRecommUse() {
		return recommUse;
	}
	public void setRecommUse(String recommUse) {
		this.recommUse = recommUse;
	}
	public String getReportUse() {
		return reportUse;
	}
	public void setReportUse(String reportUse) {
		this.reportUse = reportUse;
	}
	public String getImageAddUse() {
		return imageAddUse;
	}
	public void setImageAddUse(String imageAddUse) {
		this.imageAddUse = imageAddUse;
	}
	public String getMediaAddUse() {
		return mediaAddUse;
	}
	public void setMediaAddUse(String mediaAddUse) {
		this.mediaAddUse = mediaAddUse;
	}
	public int getCoolTime() {
		return coolTime;
	}
	public void setCoolTime(int coolTime) {
		this.coolTime = coolTime;
	}
	public int getCommentCoolTime() {
		return commentCoolTime;
	}
	public void setCommentCoolTime(int commentCoolTime) {
		this.commentCoolTime = commentCoolTime;
	}
//	public LocalDateTime getRegDate() {
//		return regDate;
//	}
//	public void setRegDate(LocalDateTime regDate) {
//		this.regDate = regDate;
//	}
//	public LocalDateTime getUpdDate() {
//		return updDate;
//	}
//	public void setUpdDate(LocalDateTime updDate) {
//		this.updDate = updDate;
//	}
	
	public List<BoardCategory> getCategory() {
		return category;
	}

	public void setCategory(List<BoardCategory> category) {
		this.category = category;
	}

	
}

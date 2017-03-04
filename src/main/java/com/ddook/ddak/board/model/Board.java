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
	private int coolTimeType;//쿨타임 타입 0:분, 1:일
	private int coolTime; //글쓰기 쿨타임
	private int commentCoolType; //댓글 쿨타임 타입 0:분, 1:일
	private int commentCoolTime; //댓글 쿨타임	 
	private int commentMaxCnt; //댓글 수
	private int writeAuthType; //쓰기타입
	private int readAuthType; //읽기 타입
	private int adminAuthType; //관리 타입
	private int writeMGrade;// 글쓰기 등급
	private int commentMGrade;//댓글쓰기 등급
	
	@Embedded
	protected UserAuditable auditable = new UserAuditable();
	
	@OneToMany(mappedBy = "board", orphanRemoval = true)
	@JsonIgnore
	private List<BoardCategory> category;
	
	public Board(){}
	
	public Board(int boardId, String boardName, String boardKorName, String boardType, String hidden, String commentUse,
			int pageLimit, String recommUse, String reportUse, String imageAddUse, String mediaAddUse, int coolTimeType,
			int coolTime, int commentCoolType, int commentCoolTime, int commentMaxCnt, int writeAuthType,
			int readAuthType, int adminAuthType, int writeMGrade, int commentMGrade) {
		super();
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
		this.coolTimeType = coolTimeType;
		this.coolTime = coolTime;
		this.commentCoolType = commentCoolType;
		this.commentCoolTime = commentCoolTime;
		this.commentMaxCnt = commentMaxCnt;
		this.writeAuthType = writeAuthType;
		this.readAuthType = readAuthType;
		this.adminAuthType = adminAuthType;
		this.writeMGrade = writeMGrade;
		this.commentMGrade = commentMGrade;
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

	public int getCoolTimeType() {
		return coolTimeType;
	}

	public void setCoolTimeType(int coolTimeType) {
		this.coolTimeType = coolTimeType;
	}

	public int getCoolTime() {
		return coolTime;
	}

	public void setCoolTime(int coolTime) {
		this.coolTime = coolTime;
	}

	public int getCommentCoolType() {
		return commentCoolType;
	}

	public void setCommentCoolType(int commentCoolType) {
		this.commentCoolType = commentCoolType;
	}

	public int getCommentCoolTime() {
		return commentCoolTime;
	}

	public void setCommentCoolTime(int commentCoolTime) {
		this.commentCoolTime = commentCoolTime;
	}

	public int getCommentMaxCnt() {
		return commentMaxCnt;
	}

	public void setCommentMaxCnt(int commentMaxCnt) {
		this.commentMaxCnt = commentMaxCnt;
	}

	public int getWriteAuthType() {
		return writeAuthType;
	}

	public void setWriteAuthType(int writeAuthType) {
		this.writeAuthType = writeAuthType;
	}

	public int getReadAuthType() {
		return readAuthType;
	}

	public void setReadAuthType(int readAuthType) {
		this.readAuthType = readAuthType;
	}

	public int getAdminAuthType() {
		return adminAuthType;
	}

	public void setAdminAuthType(int adminAuthType) {
		this.adminAuthType = adminAuthType;
	}

	public int getWriteMGrade() {
		return writeMGrade;
	}

	public void setWriteMGrade(int writeMGrade) {
		this.writeMGrade = writeMGrade;
	}

	public int getCommentMGrade() {
		return commentMGrade;
	}

	public void setCommentMGrade(int commentMGrade) {
		this.commentMGrade = commentMGrade;
	}


	public List<BoardCategory> getCategory() {
		return category;
	}

	public void setCategory(List<BoardCategory> category) {
		this.category = category;
	}
	
}

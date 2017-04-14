package com.ddook.ddak.board.model;

import java.util.List;

import com.ddook.ddak.board.entity.BoardCategories;

public class BoardModel {
		/** board_id. */
		private int boardId;

		/** 게시판영문이름. */
		private String boardName;

		/** 게시판이름. */
		private String boardKorName;

		/** 게시판타입. */
		private int boardType;

		/** 숨김여부. */
		private String hidden;

		/** 쓰기등급. */
		private int writeMGrade;

		/** 이미지 첨부 유무. */
		private String imageAddUse;

		/** 외부컨텐츠유무. */
		private String mediaAddUse;

		/** 글쓰기쿨타임. */
		private int coolTime;

		/** 추천유무. */
		private String recommUse;

		/** 신고유무. */
		private String reportUse;

		/** 게시글수. */
		private int pageLimit;

		/** 블라인드. */
		private String blind;

		/** 댓글 유무. */
		private String commentUse;

		/** 댓글유저등급. */
		private int commentMGrade;

		/** 댓글쿨타임. */
		private int commentCoolTime;

		/** 댓글신고유무. */
		private String commentReportUse;

		/** 댓글수. */
		private int commentMaxCnt;

		/** 댓글블라인드. */
		private String commentBlind;
		
		private List<BoardCategories> category;

		public int getBoardId() {
			return boardId;
		}

		public void setBoardId(int boardId) {
			System.out.println("boardId == > " + boardId);
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

		public int getBoardType() {
			return boardType;
		}

		public void setBoardType(int boardType) {
			this.boardType = boardType;
		}

		public String getHidden() {
			return hidden;
		}

		public void setHidden(String hidden) {
			this.hidden = hidden;
		}

		public int getWriteMGrade() {
			return writeMGrade;
		}

		public void setWriteMGrade(int writeMGrade) {
			this.writeMGrade = writeMGrade;
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

		public int getPageLimit() {
			return pageLimit;
		}

		public void setPageLimit(int pageLimit) {
			this.pageLimit = pageLimit;
		}

		public String getBlind() {
			return blind;
		}

		public void setBlind(String blind) {
			this.blind = blind;
		}

		public String getCommentUse() {
			return commentUse;
		}

		public void setCommentUse(String commentUse) {
			this.commentUse = commentUse;
		}

		public int getCommentMGrade() {
			return commentMGrade;
		}

		public void setCommentMGrade(int commentMGrade) {
			this.commentMGrade = commentMGrade;
		}

		public int getCommentCoolTime() {
			return commentCoolTime;
		}

		public void setCommentCoolTime(int commentCoolTime) {
			this.commentCoolTime = commentCoolTime;
		}

		public String getCommentReportUse() {
			return commentReportUse;
		}

		public void setCommentReportUse(String commentReportUse) {
			this.commentReportUse = commentReportUse;
		}

		public int getCommentMaxCnt() {
			return commentMaxCnt;
		}

		public void setCommentMaxCnt(int commentMaxCnt) {
			this.commentMaxCnt = commentMaxCnt;
		}

		public String getCommentBlind() {
			return commentBlind;
		}

		public void setCommentBlind(String commentBlind) {
			this.commentBlind = commentBlind;
		}

		public List<BoardCategories> getCategory() {
			return category;
		}

		public void setCategory(List<BoardCategories> category) {
			this.category = category;
		}

		

}

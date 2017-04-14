package com.ddook.ddak.board.component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.ddook.ddak.board.entity.BoardCategories;
import com.ddook.ddak.board.entity.Boards;
import com.ddook.ddak.board.model.BoardModel;
import com.ddook.ddak.board.service.BoardService;

@Component
public class BoardInfoComponent {
	@Autowired
	BoardService boardService;
	
	private static HashMap<String, BoardModel> boardInfoCache = new HashMap<String, BoardModel>(); 
	@Bean
	public HashMap<String, BoardModel> findBoardList(){
		List<Boards> boardList =  boardService.findBoardsForCache("boardInfos");
		List<BoardCategories> categoryList = boardService.findBoardCategories();
		List<BoardCategories> cateTemp = new ArrayList<>();
		
		HashMap<Integer, List<BoardCategories>> categories = new HashMap<>(); 
		
		for(BoardCategories cate : categoryList){
			if(categories.get(cate.getBoardId()) == null){
				cateTemp = new ArrayList<>();
				cateTemp.add(cate);
			}else{
				cateTemp.add(cate);
			}
			
			categories.put(cate.getBoardId(), cateTemp);
		}
		
		for(Boards b : boardList){				
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = null;
			try {
				jsonObj = (JSONObject)jsonParser.parse(b.getBoardAttr());
				
				BoardModel model = new BoardModel();
				model.setBlind(objectToString(jsonObj.get("blind"),"N"));
				model.setBoardId(b.getBoardId());
				model.setBoardKorName(objectToString(jsonObj.get("boardKorName"),"N"));
				model.setBoardName(b.getBoardName());
				model.setBoardType(objectToInt(jsonObj.get("boardType"),1));
				model.setCommentBlind(objectToString(jsonObj.get("commentBlind"),"N"));
				model.setCommentCoolTime(objectToInt(jsonObj.get("commentCoolTime"),0));
				model.setCommentMaxCnt(objectToInt(jsonObj.get("commentMaxCnt"),5));
				model.setCommentMGrade(objectToInt(jsonObj.get("commentMGrade"),0));
				model.setCommentReportUse(objectToString(jsonObj.get("commentReportUse"),"N"));
				model.setCommentUse(objectToString(jsonObj.get("commentUse"),"N"));
				model.setCoolTime(objectToInt(jsonObj.get("coolTime"),0));
				model.setHidden(objectToString(jsonObj.get("hidden"),"N"));
				model.setImageAddUse(objectToString(jsonObj.get("imageAddUse"),"N"));
				model.setMediaAddUse(objectToString(jsonObj.get("mediaAddUse"),"N"));
				model.setPageLimit(objectToInt(jsonObj.get("pageLimit"),10));
				model.setRecommUse(objectToString(jsonObj.get("recommUse"),"N"));
				model.setReportUse(objectToString(jsonObj.get("reportUse"),"N"));
				model.setWriteMGrade(objectToInt(jsonObj.get("writeMGrade"),0));
				
				model.setCategory(categories.get(b.getBoardId()));
				
				boardInfoCache.put(model.getBoardName(), model);
			} catch (ParseException e) {
				e.printStackTrace();
			}			
		}


		
		
		return boardInfoCache;
	}
	

	
	public static int getBoardId(String boardName){
		BoardModel board = getBoardInfo(boardName);		
		return board.getBoardId();
	}
	public static BoardModel getBoardInfo(String boardName){
		return boardInfoCache.get(boardName);
	}
	
	private int objectToInt(Object o, int defaultNum){
		return o != null ? Integer.parseInt(o+"") : defaultNum;
	}
	
	private String objectToString(Object o, String defaultStr){
		return o != null ? o+"" : defaultStr;
	}
}

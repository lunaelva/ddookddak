package com.ddook.ddak.board.model;

public enum BoardType {
	FREE(1, "자유형"), IMAGE(2, "이미지형"), NOTICE(3,"공지형");
	
	private final int value;
	private String name;
	
	private BoardType(int value, String name){
		this.value = value;
		this.setName(name);
	}
	
	public static BoardType valueOf(int key){
		BoardType result = null;
		
		for(BoardType bType : values()){
			if(bType.ordinal() == key){
				result = bType;
			}
		}
		
		return result;
	}
	
	public static String getName(int key){
		return BoardType.getName(key);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}
}

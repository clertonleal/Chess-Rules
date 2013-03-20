package com.chess.rules.domain;

public enum HorizontalMove{
	LEFT(-1),
	RIGHT(1),
	STOPED(0)
	;
	
	private int value;
	
	private HorizontalMove(final int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}

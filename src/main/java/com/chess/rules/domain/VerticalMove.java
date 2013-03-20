package com.chess.rules.domain;

public enum VerticalMove{
	UP(1),
	DOWN(-1),
	STOPED(0)
	;

	private int value;
	
	private VerticalMove(final int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
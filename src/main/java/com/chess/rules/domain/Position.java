package com.chess.rules.domain;

public class Position {

	private Integer x;
	private Integer y;
	
	public Position(final int x, final int y){
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
	
	public boolean equals(final Position position){
		if(this.x == position.getX() && this.y == position.getY()){
			return true;
		}
		return false;
	}
	
}

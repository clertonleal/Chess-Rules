package com.chess.rules.domain;

import com.chess.rules.piece.AbstractPiece;
import com.chess.rules.piece.Piece;

public class Row {

	private Piece piece;
	
	private Position position;
	
	public Row(final Position position){
		this.position = position;
	}
	
	public boolean isBusy(){
		if(this.piece == null){
			return false;
		}
		return true;
	}

	public void addPiece(final Piece piece){
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(AbstractPiece piece) {
		this.piece = piece;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}

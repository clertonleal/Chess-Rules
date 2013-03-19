package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;
import com.chess.rules.util.PositionUtil;

public abstract class AbstractPiece implements Piece{

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
	
	public enum PieceColor{
		WHITE,
		BLACK;
	}
	
	public enum PieceType{
		PAWN,
		KNIGHT,
		BISHOP,
		ROOK,
		QUEEN,
		KING;
	}
	
	private Row row;
	private PieceColor pieceColor;
	private boolean hasMoved;
	
	public AbstractPiece(final Row row, final PieceColor pieceColor){
		this.row = row;
		this.row.setPiece(this);
		this.pieceColor = pieceColor;
		this.hasMoved = false;
	}
	
	public boolean isInGame(){
		if(row == null){
			return false;
		}
		return true;
	}
	
	public boolean hasMoved(){
		return this.hasMoved;
	}
	
	public void removeFromActualRow(){
		if(!this.hasMoved){
			this.hasMoved = true;
		}
		this.row.setPiece(null);
	}
	
	private List<Position> getPositions(final HorizontalMove horizontal, final VerticalMove vertical, final boolean inLine) {
		final List<Position> positions = new ArrayList<Position>();
		int xCoordenate = getRow().getPosition().getX();
		int yCoordenate = getRow().getPosition().getY();
		
		xCoordenate += horizontal.getValue();
		yCoordenate += vertical.getValue();
		boolean inLineAux = true;
		while(PositionUtil.isValidPosition(xCoordenate, yCoordenate) && inLineAux){
			if(Board.getRows()[xCoordenate][yCoordenate].isBusy()){
				if(getPieceColor() != Board.getRows()[xCoordenate][yCoordenate].getPiece().getPieceColor()){
					positions.add(new Position(xCoordenate, yCoordenate));
				}
				break;
			}
			positions.add(new Position(xCoordenate, yCoordenate));
			xCoordenate += horizontal.getValue();
			yCoordenate += vertical.getValue();
			inLineAux = inLine;
		}
		return positions;
	}
	
	protected List<Position> getCrossPositions(final boolean inLine) {
		final List<Position> positions = new ArrayList<Position>();
		positions.addAll(getPositions(HorizontalMove.STOPED, VerticalMove.UP, inLine));
		positions.addAll(getPositions(HorizontalMove.STOPED, VerticalMove.DOWN, inLine));
		positions.addAll(getPositions(HorizontalMove.RIGHT, VerticalMove.STOPED, inLine));
		positions.addAll(getPositions(HorizontalMove.LEFT, VerticalMove.STOPED, inLine));
		return positions;
	}
	
	protected List<Position> getDiagonalPositions(final boolean inLine) {
		final List<Position> positions = new ArrayList<Position>();
		positions.addAll(getPositions(HorizontalMove.RIGHT, VerticalMove.UP, inLine));
		positions.addAll(getPositions(HorizontalMove.RIGHT, VerticalMove.DOWN, inLine));
		positions.addAll(getPositions(HorizontalMove.LEFT, VerticalMove.UP, inLine));
		positions.addAll(getPositions(HorizontalMove.LEFT, VerticalMove.DOWN, inLine));
		return positions;
	}

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}
	
	@Override
	public PieceColor getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(PieceColor pieceColor) {
		this.pieceColor = pieceColor;
	}
	
}

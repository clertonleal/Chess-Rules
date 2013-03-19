package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;
import com.chess.rules.util.PositionUtil;

public class PieceKnight extends AbstractPiece{

	public PieceKnight(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		final List<Position> positions = new ArrayList<Position>();
		final Position piecePosition = getRow().getPosition();
		Position positionAux = null;
		Row row = null;
		
		for (VerticalMove vertical : VerticalMove.values()) {
			for (HorizontalMove horizontal : HorizontalMove.values()) {
				if(horizontal == HorizontalMove.STOPED || vertical == VerticalMove.STOPED){
					continue;
				}
				
				positionAux = getVerticalKnightPosition(piecePosition, vertical, horizontal);
				row = Board.getRows()[positionAux.getX()][positionAux.getY()];
				
				if(!PositionUtil.isValidPosition(positionAux) || (row.isBusy() && getPieceColor() == row.getPiece().getPieceColor())){
					continue;
				}
				
				positions.add(positionAux);
			}
		}
		
		for (HorizontalMove horizontal : HorizontalMove.values()) {
			for (VerticalMove vertical : VerticalMove.values()) {
				
				if(horizontal == HorizontalMove.STOPED || vertical == VerticalMove.STOPED){
					continue;
				}
				
				row = Board.getRows()[positionAux.getX()][positionAux.getY()];
				positionAux = getHorizontalKnightPosition(piecePosition, horizontal, vertical);
				
				if(!PositionUtil.isValidPosition(positionAux) || (row.isBusy() && getPieceColor() == row.getPiece().getPieceColor())){
					continue;
				}
				
				positions.add(positionAux);
			}
		}
		
		return positions;
	}

	private Position getHorizontalKnightPosition(final Position piecePosition, final HorizontalMove horizontal, final VerticalMove vertical) {
		int x = piecePosition.getX() + horizontal.getValue()*2;
		int y = piecePosition.getY() + vertical.getValue();
		return new Position(x, y);
	}
	
	private Position getVerticalKnightPosition(final Position piecePosition, final VerticalMove vertical, final HorizontalMove horizontal) {
		int y = piecePosition.getY() + vertical.getValue()*2;
		int x = piecePosition.getX() + horizontal.getValue();
		return new Position(x, y);
	}
	
}

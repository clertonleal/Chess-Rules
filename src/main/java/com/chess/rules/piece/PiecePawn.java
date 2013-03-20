package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.HorizontalMove;
import com.chess.rules.domain.PieceColor;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;
import com.chess.rules.util.PositionUtil;

public class PiecePawn extends AbstractPiece{

	public PiecePawn(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		int movement = 0;
		
		if(PieceColor.WHITE == getPieceColor()){
			movement = 1; //Move to up of board.
		}else if(PieceColor.BLACK == getPieceColor()){
			movement = -1; //Move to down of board.
		}
		
		return determineFrontPawnPossiblePositions(movement);
	}

	private List<Position> determineFrontPawnPossiblePositions(final int movement) {
		final List<Position> positions = new ArrayList<Position>();
		final Position piecePosition = getRow().getPosition();
		final int x = piecePosition.getX();
		final int y = piecePosition.getY();
		
		if(!Board.getRows()[x][y + movement].isBusy() && PositionUtil.isValidPosition(x, y + movement)){
			positions.add(new Position(x, y + movement));
			
			if(!hasMoved()){ //Determine the initial move of pawn
				if(!Board.getRows()[x][y + (movement*2)].isBusy()){
					positions.add(new Position(x, y + (movement*2)));
				}
			}
		}
		
		Row rowAux = null;
		for (HorizontalMove horizontal : HorizontalMove.values()) {
			if(horizontal == HorizontalMove.STOPED){
				continue;
			}
			
			rowAux = Board.getRows()[x + horizontal.getValue()][y + movement];
			
			// In the case of an opponent's piece are in diagonal
			if(rowAux.isBusy() && rowAux.getPiece().getPieceColor() != getPieceColor()){
				positions.add(new Position(x + horizontal.getValue(), y + movement));
			}
		}
		
		return positions;
	}

}

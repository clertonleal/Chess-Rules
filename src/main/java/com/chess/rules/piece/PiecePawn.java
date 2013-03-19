package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;
import com.chess.rules.util.PositionUtil;

public class PiecePawn extends AbstractPiece{

	public PiecePawn(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		final List<Position> positions = new ArrayList<Position>();
		int movement = 0;
		if(PieceColor.WHITE == getPieceColor()){
			movement = 1;
		}else if(PieceColor.BLACK == getPieceColor()){
			movement = -1;
		}
		positions.addAll(determineFrontPawnPossiblePositions(movement));
		return positions;
	}

	private List<Position> determineFrontPawnPossiblePositions(final int movement) {
		final List<Position> positions = new ArrayList<Position>();
		final Position piecePosition = getRow().getPosition();
		final int x = piecePosition.getX();
		final int y = piecePosition.getY();
		
		if(!Board.getRows()[x][y + movement].isBusy() && PositionUtil.isValidPosition(x, y + movement)){
			positions.add(new Position(x, y + movement));
			if(!hasMoved()){
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
			if(rowAux.isBusy() && rowAux.getPiece().getPieceColor() != getPieceColor()){
				positions.add(new Position(x + horizontal.getValue(), y + movement));
			}
		}
		
		return positions;
	}

}

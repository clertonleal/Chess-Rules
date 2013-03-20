package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.PieceColor;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;

public class PieceKing extends AbstractPiece{

	public PieceKing(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		final List<Position> positions = new ArrayList<Position>();
		positions.addAll(getCrossPositions(false));
		positions.addAll(getDiagonalPositions(false));
		return positions;
	}

}

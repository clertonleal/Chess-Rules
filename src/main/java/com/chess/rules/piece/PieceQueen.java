package com.chess.rules.piece;

import java.util.List;

import com.chess.rules.domain.PieceColor;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;

public class PieceQueen extends AbstractPiece{

	public PieceQueen(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		final List<Position> positions = getCrossPositions(true);
		positions.addAll(getDiagonalPositions(true));
		return positions;
	}

}

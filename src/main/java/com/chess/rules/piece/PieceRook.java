package com.chess.rules.piece;

import java.util.List;

import com.chess.rules.domain.PieceColor;
import com.chess.rules.domain.Position;
import com.chess.rules.domain.Row;

public class PieceRook extends AbstractPiece{

	public PieceRook(Row row, PieceColor pieceColor) {
		super(row, pieceColor);
	}

	@Override
	public List<Position> getPossiblePositions() {
		return getCrossPositions(true);
	}

}

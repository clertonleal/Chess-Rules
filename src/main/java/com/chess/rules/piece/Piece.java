package com.chess.rules.piece;

import java.util.List;

import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public interface Piece {
	
	List<Position> getPossiblePositions();
	
	PieceColor getPieceColor();

}

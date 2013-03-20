package com.chess.rules.piece;

import java.util.List;

import com.chess.rules.domain.PieceColor;
import com.chess.rules.domain.Position;

public interface Piece {
	
	List<Position> getPossiblePositions();
	
	PieceColor getPieceColor();

}

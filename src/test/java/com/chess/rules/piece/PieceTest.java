package com.chess.rules.piece;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.domain.Position;

/**
 * @author Clêrton
 * Classe abstrata que todas as classes de test das peças deverão herdar.
 */
public abstract class PieceTest {
	
	protected Piece testPiece;
	protected List<Position> testPositions = new ArrayList<Position>();

	protected boolean hasAllPositions(final List<Position> positionsToTest, final List<Position> testPositions){
		boolean hasPiece = true;
		
		if(positionsToTest.size() != testPositions.size()){
			return false;
		}
		
		for (Position positionTest : testPositions) {
			if(!hasPiece){
				return false;
			}
			hasPiece = false;
			for (Position positionPiece : positionsToTest) {
				if(positionPiece.equals(positionTest)){
					hasPiece = true;
					break;
				}
			}
		}
		
		return true;
	}
	
}

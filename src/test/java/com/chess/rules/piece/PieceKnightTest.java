package com.chess.rules.piece;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public class PieceKnightTest extends PieceTest{

	@Before
	public void setUp() throws Exception {
		Board.initGame();
		testPiece = new PieceKnight(Board.getRows()[3][3], PieceColor.BLACK);
		setKnigthTestPositions();
	}

	private void setKnigthTestPositions() {
		testPositions.add(new Position(1, 4));
		testPositions.add(new Position(2, 5));
		
		testPositions.add(new Position(4, 5));
		testPositions.add(new Position(5, 4));
		
		testPositions.add(new Position(1, 2));
		testPositions.add(new Position(2, 1));
		
		testPositions.add(new Position(4, 1));
		testPositions.add(new Position(5, 2));
	}

	@Test
	public void test() {
		assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
	}

}

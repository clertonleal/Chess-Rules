package com.chess.rules.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public class PieceKingTest extends PieceTest{

	@Before
	public void setUp() throws Exception {
		Board.initGame();
		testPiece = new PieceKing(Board.getRows()[5][4], PieceColor.WHITE);
		setKingTestPositions();
	}

	private void setKingTestPositions() {
		testPositions.add(new Position(4, 3));
		testPositions.add(new Position(5, 3));
		testPositions.add(new Position(6, 3));
		
		testPositions.add(new Position(4, 5));
		testPositions.add(new Position(5, 5));
		testPositions.add(new Position(6, 5));
		
		testPositions.add(new Position(4, 4));
		testPositions.add(new Position(6, 4));
	}

	@Test
	public void test() {
		assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
	}

}

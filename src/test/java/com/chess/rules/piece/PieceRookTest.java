package com.chess.rules.piece;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public class PieceRookTest extends PieceTest{

	@Before
	public void setUp() throws Exception {
		Board.initGame();
		testPiece = new PieceRook(Board.getRows()[3][4], PieceColor.WHITE);
		setRookTestPositions();
	}

	private void setRookTestPositions() {
		testPositions.add(new Position(0, 4));
		testPositions.add(new Position(1, 4));
		testPositions.add(new Position(2, 4));
		testPositions.add(new Position(4, 4));
		testPositions.add(new Position(5, 4));
		testPositions.add(new Position(6, 4));
		testPositions.add(new Position(7, 4));

		testPositions.add(new Position(3, 2));
		testPositions.add(new Position(3, 3));
		testPositions.add(new Position(3, 5));
		testPositions.add(new Position(3, 6));
	}

	@Test
	public void test() {
		assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
	}

}

package com.chess.rules.piece;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public class PieceBishopTest extends PieceTest{

	@Before
	public void setUp() throws Exception {
		Board.initGame();
		testPiece = new PieceBishop(Board.getRows()[3][4], PieceColor.WHITE);
		setBishopTestPositions();
	}

	private void setBishopTestPositions() {
		testPositions.add(new Position(4, 5));
		testPositions.add(new Position(5, 6));
		
		testPositions.add(new Position(2, 5));
		testPositions.add(new Position(1, 6));
		
		testPositions.add(new Position(4, 3));
		testPositions.add(new Position(5, 2));
		
		testPositions.add(new Position(2, 3));
		testPositions.add(new Position(1, 2));
	}

	@Test
	public void testGetPossiblePositions() {
		Assert.assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
		Board.resetBoard();
		addBishopTestPositions();
		Assert.assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
	}

	private void addBishopTestPositions() {
		testPositions.add(new Position(0, 7));
		testPositions.add(new Position(6, 7));
		testPositions.add(new Position(0, 1));
		testPositions.add(new Position(6, 1));
		testPositions.add(new Position(7, 0));
		
	}

}

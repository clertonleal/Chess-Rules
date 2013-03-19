package com.chess.rules.piece;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.chess.rules.domain.Board;
import com.chess.rules.domain.Position;
import com.chess.rules.piece.AbstractPiece.PieceColor;

public class PiecePawnTest extends PieceTest{

	@Before
	public void setUp() throws Exception {
		Board.initGame();
		testPiece = new PiecePawn(Board.getRows()[1][1], PieceColor.WHITE);
		testPositions.add(new Position(1, 2));
		testPositions.add(new Position(1, 3));
	}
	
	@Test
	public void test() {
		Assert.assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
		setUpSecondTest();
		Assert.assertTrue(hasAllPositions(testPiece.getPossiblePositions(), testPositions));
	}
	
	private void setUpSecondTest() {
		testPiece = new PiecePawn(Board.getRows()[1][5], PieceColor.WHITE);
		testPositions = new ArrayList<Position>();
		testPositions.add(new Position(0, 6));
		testPositions.add(new Position(2, 6));
	}

}

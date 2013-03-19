package com.chess.rules.domain;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class BoardTest {

	@Before
	public void setUp() throws Exception {
		Board.initGame();
	}

	@Test
	public void testInitGame() {
		testWhitePieces();
		testBlackPieces();
	}

	private void testBlackPieces() {
		for (int y = 7; y >= 6; y--) {
			for (int x = 0; x <= 7; x++) {
				Assert.assertTrue(Board.getRows()[x][y].isBusy());
			}
		}
	}

	private void testWhitePieces() {
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x <= 7; x++) {
				Assert.assertTrue(Board.getRows()[x][y].isBusy());
			}
		}
	}
}

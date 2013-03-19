package com.chess.rules.util;

import com.chess.rules.domain.Position;

public class PositionUtil {

	private static final int MAX_X = 7;
	private static final int MAX_Y = 7;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;

	public static boolean isValidPosition(final int x, final int y) {
		if(x <= MAX_X && x >= MIN_X && y <= MAX_Y && y >= MIN_Y){
			return true;
		}
		return false;
	}

	public static boolean isValidPosition(final Position possition) {
		return isValidPosition(possition.getX(), possition.getY());
	}

}

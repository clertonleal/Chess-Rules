package com.chess.rules.util;

import com.chess.rules.domain.Row;
import com.chess.rules.piece.AbstractPiece.PieceColor;
import com.chess.rules.piece.Piece;
import com.chess.rules.piece.PieceBishop;
import com.chess.rules.piece.PieceKing;
import com.chess.rules.piece.PieceKnight;
import com.chess.rules.piece.PiecePawn;
import com.chess.rules.piece.PieceQueen;
import com.chess.rules.piece.PieceRook;

public class PieceFactory {
	
	public static Piece createPiece(final Row row, final PieceColor pieceColor, final Class<?> clazz){
		if(clazz == PieceBishop.class){
			return new PieceBishop(row, pieceColor);
			
		}else if(clazz == PieceKing.class){
			return new PieceKing(row, pieceColor);
			
		}else if(clazz == PieceKnight.class){
			return new PieceKnight(row, pieceColor);
			
		}else if(clazz == PiecePawn.class){
			return new PiecePawn(row, pieceColor);
			
		}else if(clazz == PieceQueen.class){
			return new PieceQueen(row, pieceColor);
			
		}else if(clazz == PieceRook.class){
			return new PieceRook(row, pieceColor);
			
		}
		
		return null;
	}

}

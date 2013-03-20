package com.chess.rules.domain;

import java.util.ArrayList;
import java.util.List;

import com.chess.rules.piece.Piece;
import com.chess.rules.piece.PieceBishop;
import com.chess.rules.piece.PieceKing;
import com.chess.rules.piece.PieceKnight;
import com.chess.rules.piece.PiecePawn;
import com.chess.rules.piece.PieceQueen;
import com.chess.rules.piece.PieceRook;
import com.chess.rules.util.PieceFactory;


public class Board {

	private static Row[][] rows;
	private static List<Piece> whitePiecesOutOfGame;
	private static List<Piece> blackPiecesOutOfGame;
	
	//This Array determine the order of the pieces in the board game.
	private static final Class<?>[] sequencesPiecesClass = { PieceRook.class,
			PieceKnight.class, PieceBishop.class, PieceQueen.class,
			PieceKing.class, PieceBishop.class, PieceKnight.class,
			PieceRook.class, PiecePawn.class, PiecePawn.class, PiecePawn.class,
			PiecePawn.class, PiecePawn.class, PiecePawn.class, PiecePawn.class,
			PiecePawn.class};
	
	public static void initGame(){
		initRows();
		initPieces();
		initPiecesOutOfGame();
	}
	
	public static void resetBoard(){
		clearBlackPieces();
		clearWhitePieces();
	}

	private static void initPiecesOutOfGame() {
		whitePiecesOutOfGame = new ArrayList<Piece>();
		blackPiecesOutOfGame = new ArrayList<Piece>();
	}

	private static void initPieces() {
		createBlackPieces();
		createWhitePieces();
	}

	private static void clearWhitePieces() {
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x <= 7; x++) {
				rows[x][y].setPiece(null);
			}
		}
	}

	private static void clearBlackPieces() {
		for (int y = 7; y >= 6; y--) {
			for (int x = 0; x <= 7; x++) {
				rows[x][y].setPiece(null);
			}
		}
	}

	private static void createWhitePieces() {
		Integer sequencePieces = 0;
		for (int y = 0; y <= 1; y++) {
			for (int x = 0; x <= 7; x++) {
				PieceFactory.createPiece(rows[x][y], PieceColor.WHITE, sequencesPiecesClass[sequencePieces]);
				sequencePieces++;
			}
		}
	}

	private static void createBlackPieces() {
		Integer sequencePieces = 0;
		for (int y = 7; y >= 6; y--) {
			for (int x = 0; x <= 7; x++) {
				PieceFactory.createPiece(rows[x][y], PieceColor.BLACK, sequencesPiecesClass[sequencePieces]);
				sequencePieces++;
			}
		}
	}

	private static void initRows() {
		rows = new Row[8][8];
		Row rowAux = null;
		for (int x = 0; x <= 7; x++) {
			for (int y = 0; y <= 7; y++) {
				rowAux = new Row(new Position(x, y));
				rows[x][y] = rowAux;
			}
		}
	}

	public static Row[][] getRows(){
		return rows;
	}
	
	public static List<Piece> getWhitePiecesOutOfGame(){
		return whitePiecesOutOfGame;
	}
	
	public static List<Piece> getBlackPiecesOutOfGame(){
		return blackPiecesOutOfGame;
	}
	
}

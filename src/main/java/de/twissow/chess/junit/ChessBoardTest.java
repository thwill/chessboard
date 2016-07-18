package de.twissow.chess.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;
import de.twissow.chess.board.File;
import de.twissow.chess.board.Row;
import de.twissow.chess.pieces.BlackPawn;
import de.twissow.chess.pieces.WhiteKnight;
import de.twissow.chess.pieces.WhitePawn;

public class ChessBoardTest {

  @Test
  public void TestStartPosition() {
	ChessBoard board = new ChessBoard();
	board.startPosition();
	board.calculateNextMoves();
	ChessField E2 = board.findByFileAndRow(File.FILE_E, Row.ROW_2);
	assertTrue(E2.getPiece() instanceof WhitePawn);
	assertTrue(E2.getPiece().getNextFields().size() == 2);
	assertTrue(E2.getPiece().getNextFields().contains(new ChessField(File.FILE_E, Row.ROW_3)));
	assertTrue(E2.getPiece().getNextFields().contains(new ChessField(File.FILE_E, Row.ROW_4)));

	ChessField E7 = board.findByFileAndRow(File.FILE_E, Row.ROW_7);
	assertTrue(E7.getPiece() instanceof BlackPawn);
	assertTrue(E7.getPiece().getNextFields().size() == 2);
	assertTrue(E7.getPiece().getNextFields().contains(new ChessField(File.FILE_E, Row.ROW_6)));

	assertTrue(E7.getPiece().getNextFields().contains(new ChessField(File.FILE_E, Row.ROW_5)));

	ChessField G1 = board.findByFileAndRow(File.FILE_G, Row.ROW_1);
	assertTrue(G1.getPiece() instanceof WhiteKnight);
	assertTrue(G1.getPiece().getNextFields().size() == 2);
	assertTrue(G1.getPiece().getNextFields().contains(new ChessField(File.FILE_F, Row.ROW_3)));
	assertTrue(G1.getPiece().getNextFields().contains(new ChessField(File.FILE_H, Row.ROW_3)));
  }

}

package de.twissow.chess.pieces;

import java.util.logging.Logger;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class BlackKing extends King {

  @SuppressWarnings("unused")
  private static final Logger log = Logger.getLogger(BlackKing.class.getName());

  public BlackKing() {
	super(PieceColor.BLACK);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	getNextFields().clear();
	ChessField[] fields;
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());

	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getRowNeighboursLeft(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getRowNeighboursRight(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getFileNeighboursDown(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getFileNeighboursUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByWhite())) {
	  getNextFields().add(fields[0]);
	}
	if (this.isMoved()) {
	  return;
	}
	Piece p = board.get(ChessBoard.H8).getPiece();
	if (p instanceof BlackRook) {
	  if (p.isMoved()) {
		this.kingSideRookMoved = false;
	  }
	  if (!p.isMoved() && board.get(ChessBoard.F8).isEmpty() && board.get(ChessBoard.G8).isEmpty()) {
		getNextFields().add(board.get(ChessBoard.G8));
	  }
	}
	p = board.get(ChessBoard.A8).getPiece();
	if (p instanceof BlackRook) {
	  if (p.isMoved()) {
		this.queenSideRookMoved = false;
	  }
	  if (!p.isMoved() && board.get(ChessBoard.B8).isEmpty() && board.get(ChessBoard.C8).isEmpty() && board.get(ChessBoard.D8).isEmpty()) {
		getNextFields().add(board.get(ChessBoard.C8));
	  }
	}
  }

}

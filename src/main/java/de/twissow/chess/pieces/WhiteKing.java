package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class WhiteKing extends King {

  public WhiteKing() {
	super(PieceColor.WHITE);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	getNextFields().clear();
	ChessField[] fields;
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());

	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getRowNeighboursLeft(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getRowNeighboursRight(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getFileNeighboursDown(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	fields = board.getFileNeighboursUp(this.getCurrentField());
	if (fields.length > 0 && (fields[0].isEmpty() || fields[0].isOccupiedByBlack())) {
	  getNextFields().add(fields[0]);
	}
	if (!isCastlingPossible()) {
	  return;
	}

	Piece p = board.get(ChessBoard.H1).getPiece();
	if (p instanceof WhiteRook) {
	  if (p.isMoved()) {
		this.kingSideRookMoved = false;
	  }
	  if (!p.isMoved() && board.get(ChessBoard.F1).isEmpty() && board.get(ChessBoard.G1).isEmpty()) {
		getNextFields().add(board.get(ChessBoard.G1));
	  }
	}
	p = board.get(ChessBoard.A1).getPiece();
	if (p instanceof BlackRook) {
	  if (p.isMoved()) {
		this.queenSideRookMoved = false;
	  }
	  if (!p.isMoved() && board.get(ChessBoard.B1).isEmpty() && board.get(ChessBoard.C1).isEmpty() && board.get(ChessBoard.D1).isEmpty()) {
		getNextFields().add(board.get(ChessBoard.C1));
	  }
	}

  }

}

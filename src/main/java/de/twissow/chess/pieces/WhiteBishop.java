package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class WhiteBishop extends Bishop {

  public WhiteBishop() {
	super(PieceColor.WHITE);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields;
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());
	addReachableFieldsForWhite(fields);
  }
}

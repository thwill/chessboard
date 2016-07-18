package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class BlackBishop extends Bishop {

  public BlackBishop() {
	super(PieceColor.BLACK);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields;
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	;
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());
	addReachableFieldsForBlack(fields);
  }
}

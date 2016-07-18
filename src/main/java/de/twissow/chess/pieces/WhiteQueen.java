package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class WhiteQueen extends Queen {

  public WhiteQueen() {
	super(PieceColor.WHITE);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	getNextFields().clear();
	ChessField[] fields;
	fields = board.getFileNeighboursUp(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getFileNeighboursDown(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getRowNeighboursLeft(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getRowNeighboursRight(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	addReachableFieldsForWhite(fields);
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	addReachableFieldsForWhite(fields);

  }

}

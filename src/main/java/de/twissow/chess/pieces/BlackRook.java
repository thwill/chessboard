package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class BlackRook extends Rook {

  public BlackRook() {
	super(PieceColor.BLACK);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	getNextFields().clear();
	ChessField[] fields;
	fields = board.getFileNeighboursUp(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	fields = board.getFileNeighboursDown(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	fields = board.getRowNeighboursLeft(this.getCurrentField());
	addReachableFieldsForBlack(fields);
	fields = board.getRowNeighboursRight(this.getCurrentField());
	addReachableFieldsForBlack(fields);
  }

}

package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;
import de.twissow.chess.board.Row;

public class BlackPawn extends Pawn {

  public BlackPawn() {
	super(PieceColor.BLACK);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields = board.getFileNeighboursDown(this.getCurrentField());
	if (fields.length > 0) {
	  if (fields[0].isEmpty()) {
		this.getNextFields().add(fields[0]);
	  }
	}
	if (this.getCurrentField().getRow().equals(Row.ROW_7)) {
	  if (fields[0].isEmpty() && fields[1].isEmpty()) {
		this.getNextFields().add(fields[1]);
	  }
	}
	fields = null;
	fields = board.getDiagonalNeighboursLeftDown(this.getCurrentField());
	{
	  if (fields.length > 0) {
		if (fields[0].isOccupiedByWhite()) {
		  this.getNextFields().add(fields[0]);
		}
	  }
	}
	fields = null;
	fields = board.getDiagonalNeighboursRightDown(this.getCurrentField());
	{
	  if (fields.length > 0) {
		if (fields[0].isOccupiedByWhite()) {
		  this.getNextFields().add(fields[0]);
		}
	  }
	}
  }
}

package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;
import de.twissow.chess.board.Row;

public class WhitePawn extends Pawn {

  public WhitePawn() {
	super(PieceColor.WHITE);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields = board.getFileNeighboursUp(this.getCurrentField());
	if (fields.length > 0) {
	  if (fields[0].isEmpty()) {
		this.getNextFields().add(fields[0]);
	  }
	}
	if (this.getCurrentField().getRow().equals(Row.ROW_2)) {
	  if (fields[0].isEmpty() && fields[1].isEmpty()) {
		this.getNextFields().add(fields[1]);
	  }
	}
	fields = null;
	fields = board.getDiagonalNeighboursLeftUp(this.getCurrentField());
	{
	  if (fields.length > 0) {
		if (fields[0].isOccupiedByBlack()) {
		  this.getNextFields().add(fields[0]);
		}
	  }
	}
	fields = null;
	fields = board.getDiagonalNeighboursRightUp(this.getCurrentField());
	{
	  if (fields.length > 0) {
		if (fields[0].isOccupiedByBlack()) {
		  this.getNextFields().add(fields[0]);
		}
	  }
	}

  }

}

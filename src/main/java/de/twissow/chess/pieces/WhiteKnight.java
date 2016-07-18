package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class WhiteKnight extends Knight {

  public WhiteKnight() {
	super(PieceColor.WHITE);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields;
	fields = board.getKnightJumpNeighbours(this.getCurrentField());
	addReachableFieldsForWhiteKnight(fields);
  }

  private void addReachableFieldsForWhiteKnight(ChessField[] fields) {
	for (int i = 0; i < fields.length; i++) {
	  // empty or hit
	  if (fields[i].isEmpty() || fields[i].isOccupiedByBlack()) {
		this.getNextFields().add(fields[i]);
		continue;
	  }
	  // occupied by own party
	  if (fields[i].isOccupiedByWhite()) {
		continue;
	  }
	}
  }

}

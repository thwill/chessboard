package de.twissow.chess.pieces;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public class BlackKnight extends Knight {

  public BlackKnight() {
	super(PieceColor.BLACK);
  }

  @Override
  public void calculateNextFields(ChessBoard board) {
	this.getNextFields().clear();
	ChessField[] fields;
	fields = board.getKnightJumpNeighbours(this.getCurrentField());
	addReachableFieldsForBlackKnight(fields);

  }

  private void addReachableFieldsForBlackKnight(ChessField[] fields) {
	for (int i = 0; i < fields.length; i++) {
	  // empty or hit
	  if (fields[i].isEmpty() || fields[i].isOccupiedByWhite()) {
		this.getNextFields().add(fields[i]);
		continue;
	  }
	  // occupied by own party
	  if (fields[i].isOccupiedByBlack()) {
		continue;
	  }
	}
  }

}

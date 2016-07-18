package de.twissow.chess.pieces;

import java.util.HashSet;
import java.util.Set;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;

public abstract class Piece {

  protected PieceColor color;

  private ChessField currentField;

  private Set<ChessField> nextFields = new HashSet<>();

  protected boolean moved;

  public abstract void calculateNextFields(ChessBoard board);

  protected void addReachableFieldsForWhite(ChessField[] fields) {
	for (int i = 0; i < fields.length; i++) {
	  if (fields[i].isEmpty()) {
		getNextFields().add(fields[i]);
	  }
	  if (fields[i].isOccupiedByBlack()) {
		getNextFields().add(fields[i]);
		break;
	  }
	  if (fields[i].isOccupiedByWhite()) {
		break;
	  }

	}
  }

  protected void addReachableFieldsForBlack(ChessField[] fields) {
	for (int i = 0; i < fields.length; i++) {
	  if (fields[i].isEmpty()) {
		getNextFields().add(fields[i]);
	  }
	  if (fields[i].isOccupiedByBlack()) {
		break;
	  }
	  if (fields[i].isOccupiedByWhite()) {
		getNextFields().add(fields[i]);
		break;
	  }

	}
  }

  public PieceColor getColor() {
	return color;
  }

  public Set<ChessField> getNextFields() {
	return nextFields;
  }

  public void setNextFields(Set<ChessField> nextFields) {
	this.nextFields = nextFields;
  }

  public ChessField getCurrentField() {
	return currentField;
  }

  public void setCurrentField(ChessField currentField) {
	this.currentField = currentField;
  }

  public boolean isMoved() {
	return moved;
  }

  public void setMoved(boolean moved) {
	this.moved = moved;
  }

}

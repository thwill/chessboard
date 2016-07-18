package de.twissow.chess.board;

import de.twissow.chess.pieces.PieceColor;

public class ChessMove {

  private static final String BLANK = " ";

  private static final String CASTLE_KINGSIDE = "0-0    ";

  private static final String CASTLE_QUENNSIDE = "0-0-0   ";

  private int moveNumber;

  private ChessField fromField;

  private ChessField toField;

  private boolean isHitMove;

  private boolean givesCheck;

  private boolean givesCheckMate;

  private boolean givesStaleMate;

  private boolean castleKingSide;

  private boolean castleQueenSide;

  public ChessMove(int moveNumber, ChessField fromField, ChessField toField) {
	super();
	this.moveNumber = moveNumber;
	this.fromField = fromField;
	this.toField = toField;
  }

  public int getMoveNumber() {
	return moveNumber;
  }

  public ChessField getFromField() {
	return fromField;
  }

  public ChessField getToField() {
	return toField;
  }

  public boolean isGivesCheck() {
	return givesCheck;
  }

  public void setGivesCheck(boolean givesCheck) {
	this.givesCheck = givesCheck;
  }

  public boolean isGivesCheckMate() {
	return givesCheckMate;
  }

  public void setGivesCheckMate(boolean givesCheckMate) {
	this.givesCheckMate = givesCheckMate;
  }

  public boolean isGivesStaleMate() {
	return givesStaleMate;
  }

  public void setGivesStaleMate(boolean givesStaleMate) {
	this.givesStaleMate = givesStaleMate;
  }

  public boolean isHitMove() {
	return isHitMove;
  }

  public void setHitMove(boolean isHitMove) {
	this.isHitMove = isHitMove;
  }

  @Override
  public String toString() {
	StringBuilder sb = new StringBuilder();
	if (toField.isOccupied() && toField.getPiece().getColor().equals(PieceColor.WHITE)) {
	  sb.append(moveNumber);
	  sb.append(BLANK);
	} else {
	  sb.append(BLANK);
	  sb.append(BLANK);
	  sb.append(BLANK);
	  sb.append(BLANK);
	}
	sb.append(BLANK);
	if (isCastleKingSide()) {
	  sb.append(CASTLE_KINGSIDE);
	} else if (isCastleQueenSide()) {
	  sb.append(CASTLE_QUENNSIDE);
	} else {
	  sb.append(toField.getPiece());
	  sb.append(fromField.getFile());
	  sb.append(fromField.getRow());
	  sb.append(isHitMove ? "x" : "-");
	  sb.append(toField.getFile());
	  sb.append(toField.getRow());
	}
	if (isGivesCheck()) {
	  sb.append(isGivesCheckMate() ? "#" : "+");
	}
	if (isGivesStaleMate()) {
	  sb.append(" patt");
	}
	if (toField.isOccupied() && toField.getPiece().getColor().equals(PieceColor.BLACK)) {
	  sb.append('\n');
	}
	return sb.toString();
  }

  public boolean isCastleKingSide() {
	return castleKingSide;
  }

  public void setCastleKingSide(boolean castleKingSide) {
	this.castleKingSide = castleKingSide;
  }

  public boolean isCastleQueenSide() {
	return castleQueenSide;
  }

  public void setCastleQueenSide(boolean castleQueenSide) {
	this.castleQueenSide = castleQueenSide;
  }

}

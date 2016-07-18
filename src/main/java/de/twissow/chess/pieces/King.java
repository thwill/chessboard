package de.twissow.chess.pieces;

public abstract class King extends Piece {

  protected boolean kingSideRookMoved = false;

  protected boolean queenSideRookMoved = false;

  protected King(PieceColor color) {
	this.color = color;
  }

  @Override
  public String toString() {
	return "K";
  }

  public boolean isKingSideCastlingPossible() {
	return !moved && !kingSideRookMoved;
  }

  public boolean isQueenSideCastlingPossible() {
	return !moved && !queenSideRookMoved;
  }

  public boolean isCastlingPossible() {
	return !moved && !(kingSideRookMoved && queenSideRookMoved);
  }

}

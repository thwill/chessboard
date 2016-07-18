package de.twissow.chess.pieces;

public enum PieceColor {
	WHITE,
	BLACK;

  	public static PieceColor otherColor(PieceColor color) {
  	  if (color.equals(BLACK)) {
  		return WHITE;
  	  }  else {
  		return BLACK;
  	  }
  	}
}

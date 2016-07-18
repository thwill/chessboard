package de.twissow.chess.pieces;

public abstract class Rook extends Piece {

	protected Rook(PieceColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
	  return "R";
	}



}

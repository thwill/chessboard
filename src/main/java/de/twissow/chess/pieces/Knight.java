package de.twissow.chess.pieces;

public abstract class Knight extends Piece {

	protected Knight(PieceColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
	  return "N";
	}


}

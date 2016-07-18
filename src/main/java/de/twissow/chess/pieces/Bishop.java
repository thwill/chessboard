package de.twissow.chess.pieces;

public abstract class Bishop extends Piece {

	protected Bishop(PieceColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
	  return "B";
	}


}

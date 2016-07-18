package de.twissow.chess.pieces;

public abstract class Pawn extends Piece {
	protected Pawn(PieceColor color) {
		this.color = color;
	};


	@Override
	public String toString() {
	  return " ";
	}

}

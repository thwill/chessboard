package de.twissow.chess.pieces;

public abstract class Queen extends Piece {

	protected Queen( PieceColor color) {
		this.color = color;
	}

	@Override
	public String toString() {
	  return "Q";
	}



}

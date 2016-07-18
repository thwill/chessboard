package de.twissow.chess.board;

import de.twissow.chess.pieces.BlackBishop;
import de.twissow.chess.pieces.BlackKing;
import de.twissow.chess.pieces.BlackKnight;
import de.twissow.chess.pieces.BlackPawn;
import de.twissow.chess.pieces.BlackQueen;
import de.twissow.chess.pieces.BlackRook;
import de.twissow.chess.pieces.Piece;
import de.twissow.chess.pieces.PieceColor;
import de.twissow.chess.pieces.WhiteBishop;
import de.twissow.chess.pieces.WhiteKing;
import de.twissow.chess.pieces.WhiteKnight;
import de.twissow.chess.pieces.WhitePawn;
import de.twissow.chess.pieces.WhiteQueen;
import de.twissow.chess.pieces.WhiteRook;

public class ChessField {

  @Override
  public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((file == null) ? 0 : file.hashCode());
	result = prime * result + ((row == null) ? 0 : row.hashCode());
	return result;
  }

  @Override
  public boolean equals(Object obj) {
	if (this == obj)
	  return true;
	if (obj == null)
	  return false;
	if (getClass() != obj.getClass())
	  return false;
	ChessField other = (ChessField) obj;
	if (file != other.file)
	  return false;
	if (row != other.row)
	  return false;
	return true;
  }

  @Override
  public String toString() {
	return file.toString() + row.toString();
  }

  private Piece piece;

  private Row row;
  private File file;

  public ChessField(File file, Row row) {
	this.row = row;
	this.file = file;
  }

  public ChessField(File file, Row row, Piece piece) {
	this.piece = piece;
	piece.setCurrentField(this);
	this.row = row;
	this.file = file;
  }

  public static ChessField copy(ChessField orginal) {
	ChessField copy = new ChessField(orginal.getFile(), orginal.getRow());
	Piece p = orginal.getPiece();
	if (p == null) {
	  return copy;
	}
	if (p instanceof WhitePawn) {
	  copy.setPiece(new WhitePawn());
	  return copy;
	}
	if (p instanceof BlackPawn) {
	  copy.setPiece(new BlackPawn());
	  return copy;
	}
	if (p instanceof WhiteRook) {
	  copy.setPiece(new WhiteRook());
	  return copy;
	}
	if (p instanceof BlackRook) {
	  copy.setPiece(new BlackRook());
	  return copy;
	}
	if (p instanceof WhiteKnight) {
	  copy.setPiece(new WhiteKnight());
	  return copy;
	}
	if (p instanceof BlackKnight) {
	  copy.setPiece(new BlackKnight());
	  return copy;
	}
	if (p instanceof WhiteBishop) {
	  copy.setPiece(new WhiteBishop());
	  return copy;
	}
	if (p instanceof BlackBishop) {
	  copy.setPiece(new BlackBishop());
	  return copy;
	}
	if (p instanceof WhiteQueen) {
	  copy.setPiece(new WhiteQueen());
	  return copy;
	}
	if (p instanceof BlackQueen) {
	  copy.setPiece(new BlackQueen());
	  return copy;
	}
	if (p instanceof WhiteKing) {
	  copy.setPiece(new WhiteKing());
	  return copy;
	}
	if (p instanceof BlackKing) {
	  copy.setPiece(new BlackKing());
	  return copy;
	}

	throw new IllegalStateException();
  }

  public Row getRow() {
	return row;
  }

  public File getFile() {
	return file;
  }

  public Piece getPiece() {
	return piece;
  }

  public void setPiece(Piece piece) {
	this.piece = piece;
	if (piece != null) {
	  piece.setCurrentField(this);
	}
  }

  public boolean isEmpty() {
	return piece == null;
  }

  public boolean isOccupied() {
	return piece != null;
  }

  public boolean isOccupiedByWhite() {
	return (piece != null && piece.getColor() == PieceColor.WHITE);
  }

  public boolean isOccupiedByBlack() {
	return (piece != null && piece.getColor() == PieceColor.BLACK);
  }

}

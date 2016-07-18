package de.twissow.chess.board;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.twissow.chess.pieces.BlackBishop;
import de.twissow.chess.pieces.BlackKing;
import de.twissow.chess.pieces.BlackKnight;
import de.twissow.chess.pieces.BlackPawn;
import de.twissow.chess.pieces.BlackQueen;
import de.twissow.chess.pieces.BlackRook;
import de.twissow.chess.pieces.Piece;
import de.twissow.chess.pieces.WhiteBishop;
import de.twissow.chess.pieces.WhiteKing;
import de.twissow.chess.pieces.WhiteKnight;
import de.twissow.chess.pieces.WhitePawn;
import de.twissow.chess.pieces.WhiteQueen;
import de.twissow.chess.pieces.WhiteRook;

public class ChessBoard {

  public ChessBoard(ChessBoard other) {
	for (ChessField f : other.fields) {
	  fields.add(ChessField.copy(f));
	}
	this.whiteKingsField = other.whiteKingsField;
	this.blackKingsField = other.blackKingsField;
  }

  private Set<ChessField> fields = new HashSet<>();

  private ChessField whiteKingsField;

  private ChessField blackKingsField;

  public static ChessField A1 = new ChessField(File.FILE_A, Row.ROW_1);
  public static ChessField A2 = new ChessField(File.FILE_A, Row.ROW_2);
  public static ChessField A3 = new ChessField(File.FILE_A, Row.ROW_3);
  public static ChessField A4 = new ChessField(File.FILE_A, Row.ROW_4);
  public static ChessField A5 = new ChessField(File.FILE_A, Row.ROW_5);
  public static ChessField A6 = new ChessField(File.FILE_A, Row.ROW_6);
  public static ChessField A7 = new ChessField(File.FILE_A, Row.ROW_7);
  public static ChessField A8 = new ChessField(File.FILE_A, Row.ROW_8);

  public static ChessField B1 = new ChessField(File.FILE_B, Row.ROW_1);
  public static ChessField B2 = new ChessField(File.FILE_B, Row.ROW_2);
  public static ChessField B3 = new ChessField(File.FILE_B, Row.ROW_3);
  public static ChessField B4 = new ChessField(File.FILE_B, Row.ROW_4);
  public static ChessField B5 = new ChessField(File.FILE_B, Row.ROW_5);
  public static ChessField B6 = new ChessField(File.FILE_B, Row.ROW_6);
  public static ChessField B7 = new ChessField(File.FILE_B, Row.ROW_7);
  public static ChessField B8 = new ChessField(File.FILE_B, Row.ROW_8);

  public static ChessField C1 = new ChessField(File.FILE_C, Row.ROW_1);
  public static ChessField C2 = new ChessField(File.FILE_C, Row.ROW_2);
  public static ChessField C3 = new ChessField(File.FILE_C, Row.ROW_3);
  public static ChessField C4 = new ChessField(File.FILE_C, Row.ROW_4);
  public static ChessField C5 = new ChessField(File.FILE_C, Row.ROW_5);
  public static ChessField C6 = new ChessField(File.FILE_C, Row.ROW_6);
  public static ChessField C7 = new ChessField(File.FILE_C, Row.ROW_7);
  public static ChessField C8 = new ChessField(File.FILE_C, Row.ROW_8);

  public static ChessField D1 = new ChessField(File.FILE_D, Row.ROW_1);
  public static ChessField D2 = new ChessField(File.FILE_D, Row.ROW_2);
  public static ChessField D3 = new ChessField(File.FILE_D, Row.ROW_3);
  public static ChessField D4 = new ChessField(File.FILE_D, Row.ROW_4);
  public static ChessField D5 = new ChessField(File.FILE_D, Row.ROW_5);
  public static ChessField D6 = new ChessField(File.FILE_D, Row.ROW_6);
  public static ChessField D7 = new ChessField(File.FILE_D, Row.ROW_7);
  public static ChessField D8 = new ChessField(File.FILE_D, Row.ROW_8);

  public static ChessField E1 = new ChessField(File.FILE_E, Row.ROW_1);
  public static ChessField E2 = new ChessField(File.FILE_E, Row.ROW_2);
  public static ChessField E3 = new ChessField(File.FILE_E, Row.ROW_3);
  public static ChessField E4 = new ChessField(File.FILE_E, Row.ROW_4);
  public static ChessField E5 = new ChessField(File.FILE_E, Row.ROW_5);
  public static ChessField E6 = new ChessField(File.FILE_E, Row.ROW_6);
  public static ChessField E7 = new ChessField(File.FILE_E, Row.ROW_7);
  public static ChessField E8 = new ChessField(File.FILE_E, Row.ROW_8);

  public static ChessField F1 = new ChessField(File.FILE_F, Row.ROW_1);
  public static ChessField F2 = new ChessField(File.FILE_F, Row.ROW_2);
  public static ChessField F3 = new ChessField(File.FILE_F, Row.ROW_3);
  public static ChessField F4 = new ChessField(File.FILE_F, Row.ROW_4);
  public static ChessField F5 = new ChessField(File.FILE_F, Row.ROW_5);
  public static ChessField F6 = new ChessField(File.FILE_F, Row.ROW_6);
  public static ChessField F7 = new ChessField(File.FILE_F, Row.ROW_7);
  public static ChessField F8 = new ChessField(File.FILE_F, Row.ROW_8);

  public static ChessField G1 = new ChessField(File.FILE_G, Row.ROW_1);
  public static ChessField G2 = new ChessField(File.FILE_G, Row.ROW_2);
  public static ChessField G3 = new ChessField(File.FILE_G, Row.ROW_3);
  public static ChessField G4 = new ChessField(File.FILE_G, Row.ROW_4);
  public static ChessField G5 = new ChessField(File.FILE_G, Row.ROW_5);
  public static ChessField G6 = new ChessField(File.FILE_G, Row.ROW_6);
  public static ChessField G7 = new ChessField(File.FILE_G, Row.ROW_7);
  public static ChessField G8 = new ChessField(File.FILE_G, Row.ROW_8);

  public static ChessField H1 = new ChessField(File.FILE_H, Row.ROW_1);
  public static ChessField H2 = new ChessField(File.FILE_H, Row.ROW_2);
  public static ChessField H3 = new ChessField(File.FILE_H, Row.ROW_3);
  public static ChessField H4 = new ChessField(File.FILE_H, Row.ROW_4);
  public static ChessField H5 = new ChessField(File.FILE_H, Row.ROW_5);
  public static ChessField H6 = new ChessField(File.FILE_H, Row.ROW_6);
  public static ChessField H7 = new ChessField(File.FILE_H, Row.ROW_7);
  public static ChessField H8 = new ChessField(File.FILE_H, Row.ROW_8);

  public ChessBoard() {
	fields.add(A1);
	fields.add(A2);
	fields.add(A3);
	fields.add(A4);
	fields.add(A5);
	fields.add(A6);
	fields.add(A7);
	fields.add(A8);

	fields.add(B1);
	fields.add(B2);
	fields.add(B3);
	fields.add(B4);
	fields.add(B5);
	fields.add(B6);
	fields.add(B7);
	fields.add(B8);

	fields.add(C1);
	fields.add(C2);
	fields.add(C3);
	fields.add(C4);
	fields.add(C5);
	fields.add(C6);
	fields.add(C7);
	fields.add(C8);

	fields.add(D1);
	fields.add(D2);
	fields.add(D3);
	fields.add(D4);
	fields.add(D5);
	fields.add(D6);
	fields.add(D7);
	fields.add(D8);

	fields.add(E1);
	fields.add(E2);
	fields.add(E3);
	fields.add(E4);
	fields.add(E5);
	fields.add(E6);
	fields.add(E7);
	fields.add(E8);

	fields.add(F1);
	fields.add(F2);
	fields.add(F3);
	fields.add(F4);
	fields.add(F5);
	fields.add(F6);
	fields.add(F7);
	fields.add(F8);

	fields.add(G1);
	fields.add(G2);
	fields.add(G3);
	fields.add(G4);
	fields.add(G5);
	fields.add(G6);
	fields.add(G7);
	fields.add(G8);

	fields.add(H1);
	fields.add(H2);
	fields.add(H3);
	fields.add(H4);
	fields.add(H5);
	fields.add(H6);
	fields.add(H7);
	fields.add(H8);
  }

  public void startPosition() {
	A2.setPiece(new WhitePawn());
	B2.setPiece(new WhitePawn());
	C2.setPiece(new WhitePawn());
	D2.setPiece(new WhitePawn());
	E2.setPiece(new WhitePawn());
	F2.setPiece(new WhitePawn());
	G2.setPiece(new WhitePawn());
	H2.setPiece(new WhitePawn());
	A1.setPiece(new WhiteRook());
	B1.setPiece(new WhiteKnight());
	C1.setPiece(new WhiteBishop());
	D1.setPiece(new WhiteQueen());
	E1.setPiece(new WhiteKing());
	setWhiteKingsField(E1);
	F1.setPiece(new WhiteBishop());
	G1.setPiece(new WhiteKnight());
	H1.setPiece(new WhiteRook());

	A7.setPiece(new BlackPawn());
	B7.setPiece(new BlackPawn());
	C7.setPiece(new BlackPawn());
	D7.setPiece(new BlackPawn());
	E7.setPiece(new BlackPawn());
	F7.setPiece(new BlackPawn());
	G7.setPiece(new BlackPawn());
	H7.setPiece(new BlackPawn());
	A8.setPiece(new BlackRook());
	B8.setPiece(new BlackKnight());
	C8.setPiece(new BlackBishop());
	D8.setPiece(new BlackQueen());
	E8.setPiece(new BlackKing());
	setBlackKingsField(E8);
	F8.setPiece(new BlackBishop());
	G8.setPiece(new BlackKnight());
	H8.setPiece(new BlackRook());
  }

  public void calculateNextMoves() {
	for (ChessField f : this.getFields()) {
	  Piece p = f.getPiece();
	  if (p != null) {
		p.getNextFields().clear();
		p.calculateNextFields(this);
	  }
	}

  }

  public void move(ChessField fromField, ChessField toField) {
	toField.setPiece(fromField.getPiece());
	fromField.setPiece(null);
	if (toField.getPiece() instanceof WhiteKing) {
	  setWhiteKingsField(toField);
	}
	if (toField.getPiece() instanceof BlackKing) {
	  setBlackKingsField(toField);
	}
	fields.add(fromField);
	fields.add(toField);
  }

  public void moveEnPassant(ChessField fromField, ChessField toField, ChessField hitPawnField) {
	toField.setPiece(fromField.getPiece());
	fromField.setPiece(null);
	hitPawnField.setPiece(null);
	fields.add(fromField);
	fields.add(toField);
	fields.add(hitPawnField);
  }

  public boolean checkForWhiteInCheck() {
	this.calculateNextMoves();
	for (ChessField field : fields) {
	  if (field.isOccupiedByBlack()) {
		Piece p = field.getPiece();
		if (p.getNextFields().contains(whiteKingsField)) {
		  return true;
		}
	  }
	}
	return false;
  }

  public boolean checkForBlackInCheck() {
	this.calculateNextMoves();
	for (ChessField field : fields) {
	  if (field.isOccupiedByWhite()) {
		Piece p = field.getPiece();
		if (p.getNextFields().contains(blackKingsField)) {
		  return true;
		}
	  }
	}
	return false;
  }

  public ChessField findByFileAndRow(File file, Row row) {
	for (ChessField field : fields) {
	  if (field.getFile() == file && field.getRow() == row) {
		return field;
	  }
	}
	return null;
  }

  public ChessField[] getRowNeighboursRight(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	Row row = field.getRow();
	int fileIndex = field.getFile().getIndex() + 1;
	while (fileIndex <= 7) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), row));
	  fileIndex++;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getRowNeighboursLeft(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	Row row = field.getRow();
	int fileIndex = field.getFile().getIndex() - 1;
	while (fileIndex >= 0) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), row));
	  fileIndex--;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getFileNeighboursUp(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	File file = field.getFile();
	int rowIndex = field.getRow().getIndex() - 1;
	while (rowIndex >= 0) {
	  neighbourFields.add(findByFileAndRow(file, Row.getByIndex(rowIndex)));
	  rowIndex--;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getFileNeighboursDown(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	File file = field.getFile();
	int rowIndex = field.getRow().getIndex() + 1;
	while (rowIndex <= 7) {
	  neighbourFields.add(findByFileAndRow(file, Row.getByIndex(rowIndex)));
	  rowIndex++;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getDiagonalNeighboursRightDown(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	int rowIndex = field.getRow().getIndex() + 1;
	int fileIndex = field.getFile().getIndex() + 1;
	while (fileIndex <= 7 && rowIndex <= 7) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), Row.getByIndex(rowIndex)));
	  rowIndex++;
	  fileIndex++;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getDiagonalNeighboursLeftDown(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	int rowIndex = field.getRow().getIndex() + 1;
	int fileIndex = field.getFile().getIndex() - 1;
	while (fileIndex >= 0 && rowIndex <= 7) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), Row.getByIndex(rowIndex)));
	  rowIndex++;
	  fileIndex--;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getDiagonalNeighboursRightUp(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	int rowIndex = field.getRow().getIndex() - 1;
	int fileIndex = field.getFile().getIndex() + 1;
	while (fileIndex <= 7 && rowIndex >= 0) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), Row.getByIndex(rowIndex)));
	  rowIndex--;
	  fileIndex++;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getDiagonalNeighboursLeftUp(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	int rowIndex = field.getRow().getIndex() - 1;
	int fileIndex = field.getFile().getIndex() - 1;
	while (fileIndex >= 0 && rowIndex >= 0) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileIndex), Row.getByIndex(rowIndex)));
	  rowIndex--;
	  fileIndex--;
	}
	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  public ChessField[] getKnightJumpNeighbours(ChessField field) {
	List<ChessField> neighbourFields = new ArrayList<>();
	int rowIndex = field.getRow().getIndex();
	int fileIndex = field.getFile().getIndex();
	int rowTargetIndex;
	int fileTargetIndex;

	rowTargetIndex = rowIndex + 2;
	fileTargetIndex = fileIndex - 1;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}
	rowTargetIndex = rowIndex + 2;
	fileTargetIndex = fileIndex + 1;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex + 1;
	fileTargetIndex = fileIndex + 2;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex - 1;
	fileTargetIndex = fileIndex + 2;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex - 2;
	fileTargetIndex = fileIndex + 1;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex - 2;
	fileTargetIndex = fileIndex - 1;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex - 1;
	fileTargetIndex = fileIndex - 2;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	rowTargetIndex = rowIndex + 1;
	fileTargetIndex = fileIndex - 2;
	if (inBoardRange(rowTargetIndex) && inBoardRange(fileTargetIndex)) {
	  neighbourFields.add(findByFileAndRow(File.getByIndex(fileTargetIndex), Row.getByIndex(rowTargetIndex)));
	}

	return neighbourFields.toArray(new ChessField[neighbourFields.size()]);
  };

  private boolean inBoardRange(int index) {
	return (0 <= index && index <= 7);
  }

  public Set<ChessField> getFields() {
	return fields;
  }

  public ChessField getWhiteKingsField() {
	return whiteKingsField;
  }

  public void setWhiteKingsField(ChessField whiteKingsField) {
	this.whiteKingsField = whiteKingsField;
  }

  public ChessField getBlackKingsField() {
	return blackKingsField;
  }

  public void setBlackKingsField(ChessField blackKingsField) {
	this.blackKingsField = blackKingsField;
  }

  public ChessField get(ChessField other) {
	for (ChessField myField : fields) {
	  if (myField.equals(other)) {
		return myField;
	  }
	}
	return null;
  }

}

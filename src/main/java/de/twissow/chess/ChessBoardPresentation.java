package de.twissow.chess;

import de.twissow.chess.board.ChessBoard;
import de.twissow.chess.board.ChessField;
import de.twissow.chess.board.ChessGamePosition;
import de.twissow.chess.pieces.PieceColor;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;

public class ChessBoardPresentation extends Pane {

  private ChessFieldPresentation[][] chessFieldPresentations = new ChessFieldPresentation[8][8];
  private ChessGamePosition gamePosition = new ChessGamePosition();
  private ChessField selectedField;
  private Translate pos;

  public ChessBoardPresentation() {
	ChessBoard cb = new ChessBoard();
	cb.startPosition();
	cb.calculateNextMoves();
	gamePosition.setChessBoard(cb);
	presentateGamePosition();
	pos = new Translate();
  }

  private void presentateGamePosition() {
	for (ChessField f : gamePosition.getChessBoard().getFields()) {
	  chessFieldPresentations[f.getFile().getIndex()][f.getRow().getIndex()] = new ChessFieldPresentation(f);
	}
  }

  public void placeBoard(int i, int j) {
	getChildren().addAll(chessFieldPresentations[i][j].getRectangle());
  }

  public void placeImage(int i, int j) {
	getChildren().addAll(chessFieldPresentations[i][j].getImageView());
  }

  @Override
  public void relocate(double x, double y) {
	super.relocate(x, y);
	pos.setX(x);
	pos.setY(x);
  }

  public void handleMouseTargetClick(int hashCode) {
	ChessField f = findByClickedTarget(hashCode);
	if (f == null) {
	  return;
	}
	if (selectedField == null) {
	  return;
	}
	if (selectedField.getPiece().getNextFields().contains(f)) {
	  gamePosition.move(getSelectedField(), f);
	  setSelectedField(null);
	  presentateGamePosition();
	}
  }

  public void handleMouseSelectionClick(int hashCode) {

	ChessField f = findByClickedTarget(hashCode);
	if (f == null) {
	  return;
	}
	// unselect
	if (chessFieldPresentations[f.getFile().getIndex()][f.getRow().getIndex()].isSelected()) {

	  chessFieldPresentations[f.getFile().getIndex()][f.getRow().getIndex()] = new ChessFieldPresentation(f);
	  for (ChessField nf : f.getPiece().getNextFields()) {
		chessFieldPresentations[nf.getFile().getIndex()][nf.getRow().getIndex()] = new ChessFieldPresentation(nf);
	  }
	  setSelectedField(null);
	  return;
	}

	// select white
	if (this.gamePosition.getColorToMove().equals(PieceColor.WHITE)) {
	  if (f.isOccupiedByWhite()) {
		select(f);
	  }
	}

	// select black
	if (this.gamePosition.getColorToMove().equals(PieceColor.BLACK)) {
	  if (f.isOccupiedByBlack()) {
		select(f);
	  }
	}
  }

  private void select(ChessField f) {
	if (f.getPiece().getNextFields().size() > 0) {
	  unselectPrevious();
	  setSelectedField(f);
	  chessFieldPresentations[f.getFile().getIndex()][f.getRow().getIndex()] = new ChessFieldPresentation(f, true, false);
	  for (ChessField nf : f.getPiece().getNextFields()) {
		chessFieldPresentations[nf.getFile().getIndex()][nf.getRow().getIndex()] = new ChessFieldPresentation(nf, false, true);
	  }
	}
  }

  private void unselectPrevious() {
	if (selectedField != null) {
	  chessFieldPresentations[selectedField.getFile().getIndex()][selectedField.getRow().getIndex()] = new ChessFieldPresentation(selectedField);
	  for (ChessField nf : selectedField.getPiece().getNextFields()) {
		chessFieldPresentations[nf.getFile().getIndex()][nf.getRow().getIndex()] = new ChessFieldPresentation(nf);
	  }
	}
  }

  private ChessField findByClickedTarget(int hashCode) {
	for (int i = 0; i < 8; i++) {
	  for (int j = 0; j < 8; j++) {
		ChessFieldPresentation cfp = this.chessFieldPresentations[i][j];
		if (cfp.getImageView().hashCode() == hashCode || cfp.getRectangle().hashCode() == hashCode) {
		  return cfp.getField();
		}
	  }
	}
	return null;
  }

  public ChessField getSelectedField() {
	return selectedField;
  }

  public void setSelectedField(ChessField selectedField) {
	this.selectedField = selectedField;
  }
}

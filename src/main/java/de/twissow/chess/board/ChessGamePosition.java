package de.twissow.chess.board;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import de.twissow.chess.pieces.BlackKing;
import de.twissow.chess.pieces.BlackPawn;
import de.twissow.chess.pieces.King;
import de.twissow.chess.pieces.Piece;
import de.twissow.chess.pieces.PieceColor;
import de.twissow.chess.pieces.WhiteKing;
import de.twissow.chess.pieces.WhitePawn;

public class ChessGamePosition {

  private static final Logger log = Logger.getLogger(ChessGamePosition.class.getName());

  private int moveNumber;

  private PieceColor colorToMove = PieceColor.WHITE;

  private ChessBoard chessBoard;

  private LinkedList<ChessMove> moves = new LinkedList<>();

  public int getMoveNumber() {
	return moveNumber;
  }

  public void setMoveNumber(int moveNumber) {
	this.moveNumber = moveNumber;
  }

  public PieceColor getColorToMove() {
	return colorToMove;
  }

  public void setColorToMove(PieceColor colorToMove) {
	this.colorToMove = colorToMove;
  }

  public ChessBoard getChessBoard() {
	return chessBoard;
  }

  public void setChessBoard(ChessBoard currentPosition) {
	this.chessBoard = currentPosition;
  }

  public void move(ChessField fromField, ChessField toField) {

	boolean hitMove = false;
	if (getColorToMove().equals(PieceColor.BLACK)) {
	  if (toField.isOccupiedByWhite()) {
		hitMove = true;
	  }
	  if (toField.isEmpty() && fromField.getPiece() instanceof BlackPawn) {
		if (toField.getFile().getIndex() != fromField.getFile().getIndex()) {
		  hitMove = true;
		  ChessField enPassantField = chessBoard.findByFileAndRow(toField.getFile(), Row.ROW_4);
		  enPassantField.setPiece(null);
		  chessBoard.getFields().add(enPassantField);
		}

	  }
	  setColorToMove(PieceColor.WHITE);
	} else {
	  moveNumber++;
	  if (toField.isOccupiedByBlack()) {
		hitMove = true;
	  }
	  if (toField.isEmpty() && fromField.getPiece() instanceof WhitePawn) {
		if (toField.getFile().getIndex() != fromField.getFile().getIndex()) {
		  hitMove = true;
		  ChessField enPassantField = chessBoard.findByFileAndRow(toField.getFile(), Row.ROW_5);
		  enPassantField.setPiece(null);
		  chessBoard.getFields().add(enPassantField);
		}
	  }
	  setColorToMove(PieceColor.BLACK);
	}

	toField.setPiece(fromField.getPiece());
	fromField.setPiece(null);
	toField.getPiece().setMoved(true);
	ChessMove move = new ChessMove(moveNumber, fromField, toField);
	move.setHitMove(hitMove);
	chessBoard.getFields().add(fromField);
	chessBoard.getFields().add(toField);

	if (toField.getPiece() instanceof WhiteKing) {
	  getChessBoard().setWhiteKingsField(toField);
	  if (fromField.equals(ChessBoard.E1) && (toField.equals(ChessBoard.G1))) {
		chessBoard.get(ChessBoard.F1).setPiece(chessBoard.get(ChessBoard.H1).getPiece());
		chessBoard.get(ChessBoard.H1).setPiece(null);
		move.setCastleKingSide(true);
	  }
	  if (fromField.equals(ChessBoard.E1) && (toField.equals(ChessBoard.C1))) {
		chessBoard.get(ChessBoard.D1).setPiece(chessBoard.get(ChessBoard.A1).getPiece());
		chessBoard.get(ChessBoard.A1).setPiece(null);
		move.setCastleQueenSide(true);
	  }
	}

	if (toField.getPiece() instanceof BlackKing) {
	  getChessBoard().setBlackKingsField(toField);
	  if (fromField.equals(ChessBoard.E8) && (toField.equals(ChessBoard.G8))) {
		chessBoard.get(ChessBoard.F8).setPiece(chessBoard.get(ChessBoard.H8).getPiece());
		chessBoard.get(ChessBoard.H8).setPiece(null);
		move.setCastleKingSide(true);
	  }
	  if (fromField.equals(ChessBoard.E8) && (toField.equals(ChessBoard.C8))) {
		chessBoard.get(ChessBoard.D8).setPiece(chessBoard.get(ChessBoard.A8).getPiece());
		chessBoard.get(ChessBoard.A8).setPiece(null);
		move.setCastleQueenSide(true);
	  }
	}
	if (checkForCheck(chessBoard)) {
	  move.setGivesCheck(true);
	}
	if (checkForCheckMate()) {
	  move.setGivesCheckMate(true);
	}
	if (checkForStaleMate()) {
	  move.setGivesStaleMate(true);
	}
	moves.add(move);
	System.out.println(moves.getLast());
	calculateNext();
  }

  private void calculateNext() {
	this.getChessBoard().calculateNextMoves();
	List<ChessField> forbidden;
	ChessBoard testBoard;
	if (getColorToMove() == PieceColor.WHITE) {
	  for (ChessField f : this.chessBoard.getFields()) {
		if (f.isOccupiedByWhite()) {
		  Piece p = f.getPiece();
		  // pruefe en passant
		  if (p instanceof WhitePawn) {
			checkEnPassantWhite(p);
		  }
		  if (!p.getNextFields().isEmpty()) {
			forbidden = new ArrayList<>();
			for (ChessField tf : p.getNextFields()) {
			  testBoard = new ChessBoard(chessBoard);
			  testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(tf.getFile(), tf.getRow()));
			  testBoard.calculateNextMoves();
			  if (testBoard.checkForWhiteInCheck()) {
				forbidden.add(tf);
				log.info("Nach " + f.getPiece() + f.toString() + "-" + tf.toString() + " ist Weiss im Schach !");
			  }
			  checkCastlingWhite(forbidden, f, p, tf);
			}
			p.getNextFields().removeAll(forbidden);
		  }
		}
	  }
	}

	if (getColorToMove() == PieceColor.BLACK) {
	  for (ChessField f : this.chessBoard.getFields()) {
		if (f.isOccupiedByBlack()) {
		  Piece p = f.getPiece();
		  if (p instanceof BlackPawn) {
			checkEnPassantBlack(p);
		  }
		  if (!p.getNextFields().isEmpty()) {
			forbidden = new ArrayList<>();
			for (ChessField tf : p.getNextFields()) {
			  testBoard = new ChessBoard(chessBoard);
			  testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(tf.getFile(), tf.getRow()));
			  testBoard.calculateNextMoves();
			  if (testBoard.checkForBlackInCheck()) {
				forbidden.add(tf);
				log.info("Nach " + f.getPiece() + f.toString() + "-" + tf.toString() + " ist Schwarz im Schach !");
			  }
			  checkCastlingBlack(forbidden, f, p, tf);
			}
			f.getPiece().getNextFields().removeAll(forbidden);
		  }
		}
	  }
	}

  }

  private void checkCastlingBlack(List<ChessField> forbidden, ChessField f, Piece p, ChessField tf) {
	ChessBoard testBoard;
	if (p instanceof BlackKing) {
	  if (((King) p).isKingSideCastlingPossible() && tf.equals(ChessBoard.G8)) {
		testBoard = new ChessBoard(chessBoard);
		testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(ChessBoard.F8.getFile(), ChessBoard.F8.getRow()));
		testBoard.calculateNextMoves();
		if (testBoard.checkForWhiteInCheck()) {
		  log.info("Kurze Rochade für Schwarz nicht möglich !");
		  forbidden.add(tf);
		}

	  }
	  if (((King) p).isQueenSideCastlingPossible() && tf.equals(ChessBoard.C8)) {
		testBoard = new ChessBoard(chessBoard);
		testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(ChessBoard.D8.getFile(), ChessBoard.D8.getRow()));
		testBoard.calculateNextMoves();
		if (testBoard.checkForWhiteInCheck()) {
		  log.info("Lange Rochade für Schwarz nicht möglich !");
		  forbidden.add(tf);
		}

	  }
	}
  }

  private void checkCastlingWhite(List<ChessField> forbidden, ChessField f, Piece p, ChessField tf) {
	ChessBoard testBoard;
	if (p instanceof WhiteKing) {
	  if (((King) p).isKingSideCastlingPossible() && tf.equals(ChessBoard.G1)) {
		testBoard = new ChessBoard(chessBoard);
		testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(ChessBoard.F1.getFile(), ChessBoard.F1.getRow()));
		testBoard.calculateNextMoves();
		if (testBoard.checkForWhiteInCheck()) {
		  log.info("Kurze Rochade für Weiss nicht möglich !");
		  forbidden.add(tf);
		}

	  }
	  if (((King) p).isQueenSideCastlingPossible() && tf.equals(ChessBoard.C1)) {
		testBoard = new ChessBoard(chessBoard);
		testBoard.move(testBoard.findByFileAndRow(f.getFile(), f.getRow()), testBoard.findByFileAndRow(ChessBoard.D1.getFile(), ChessBoard.D1.getRow()));
		testBoard.calculateNextMoves();
		if (testBoard.checkForWhiteInCheck()) {
		  log.info("Lange Rochade für Weiss nicht möglich !");
		  forbidden.add(tf);
		}

	  }
	}
  }

  private void checkEnPassantWhite(Piece p) {
	ChessBoard testBoard;
	if (p.getCurrentField().getRow().equals(Row.ROW_5)) {
	  File file = p.getCurrentField().getFile();
	  ChessMove lastMove = moves.getLast();
	  if (file.equals(File.FILE_A)) {
		if (lastMove.getFromField().equals(ChessBoard.B7) && lastMove.getToField().equals(ChessBoard.B5)) {
		  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			testBoard = new ChessBoard(chessBoard);
			ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.B6), testBoard.get(ChessBoard.B5));
			testBoard.calculateNextMoves();
			if (!testBoard.checkForWhiteInCheck()) {
			  p.getNextFields().add(chessBoard.get(ChessBoard.B6));
			}
		  }
		}
	  } else if (file.equals(File.FILE_B)) {
		if (lastMove.getFromField().equals(ChessBoard.A7) && lastMove.getToField().equals(ChessBoard.A5)) {
		  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			testBoard = new ChessBoard(chessBoard);
			ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.A6), testBoard.get(ChessBoard.A5));
			if (!testBoard.checkForWhiteInCheck()) {
			  p.getNextFields().add(chessBoard.get(ChessBoard.A6));
			}
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.C7) && lastMove.getToField().equals(ChessBoard.C5)) {
		  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			testBoard = new ChessBoard(chessBoard);
			ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.C6), testBoard.get(ChessBoard.C5));
			if (!testBoard.checkForWhiteInCheck()) {
			  p.getNextFields().add(chessBoard.get(ChessBoard.C6));
			}
		  }
		}
	  } else if (file.equals(File.FILE_C)) {
		if (lastMove.getFromField().equals(ChessBoard.B7) && lastMove.getToField().equals(ChessBoard.B5)) {
		  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			testBoard = new ChessBoard(chessBoard);
			ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.B6), testBoard.get(ChessBoard.B5));
			if (!testBoard.checkForWhiteInCheck()) {
			  p.getNextFields().add(chessBoard.get(ChessBoard.B6));
			}
		  }
		  if (lastMove.getFromField().equals(ChessBoard.D7) && lastMove.getToField().equals(ChessBoard.D5)) {
			if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			  testBoard = new ChessBoard(chessBoard);
			  ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			  testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.D6), testBoard.get(ChessBoard.D5));
			  if (!testBoard.checkForWhiteInCheck()) {
				p.getNextFields().add(chessBoard.get(ChessBoard.D6));
			  }
			}
		  }
		} else if (file.equals(File.FILE_D)) {
		  if (lastMove.getFromField().equals(ChessBoard.C7) && lastMove.getToField().equals(ChessBoard.C5)) {
			if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			  testBoard = new ChessBoard(chessBoard);
			  ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			  testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.C6), testBoard.get(ChessBoard.C5));
			  if (!testBoard.checkForWhiteInCheck()) {
				p.getNextFields().add(chessBoard.get(ChessBoard.C6));
			  }
			}
			if (lastMove.getFromField().equals(ChessBoard.E7) && lastMove.getToField().equals(ChessBoard.E5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				testBoard = new ChessBoard(chessBoard);
				ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.E6), testBoard.get(ChessBoard.E5));
				if (!testBoard.checkForWhiteInCheck()) {
				  p.getNextFields().add(chessBoard.get(ChessBoard.E6));
				}
			  }
			}
		  } else if (file.equals(File.FILE_E)) {
			if (lastMove.getFromField().equals(ChessBoard.D7) && lastMove.getToField().equals(ChessBoard.D5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				testBoard = new ChessBoard(chessBoard);
				ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.D6), testBoard.get(ChessBoard.D5));
				if (!testBoard.checkForWhiteInCheck()) {
				  p.getNextFields().add(chessBoard.get(ChessBoard.D6));
				}
			  }
			}
			if (lastMove.getFromField().equals(ChessBoard.F7) && lastMove.getToField().equals(ChessBoard.F5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				testBoard = new ChessBoard(chessBoard);
				ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.F6), testBoard.get(ChessBoard.F5));
				if (!testBoard.checkForWhiteInCheck()) {
				  p.getNextFields().add(chessBoard.get(ChessBoard.F6));
				}
			  }
			}
		  } else if (file.equals(File.FILE_F)) {
			if (lastMove.getFromField().equals(ChessBoard.E7) && lastMove.getToField().equals(ChessBoard.E5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				testBoard = new ChessBoard(chessBoard);
				ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.E6), testBoard.get(ChessBoard.E5));
				if (!testBoard.checkForWhiteInCheck()) {
				  p.getNextFields().add(chessBoard.get(ChessBoard.E6));
				}
			  }
			}
			if (lastMove.getFromField().equals(ChessBoard.G7) && lastMove.getToField().equals(ChessBoard.G5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				  testBoard = new ChessBoard(chessBoard);
				  ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				  testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.G6), testBoard.get(ChessBoard.G5));
				  if (!testBoard.checkForWhiteInCheck()) {
					p.getNextFields().add(chessBoard.get(ChessBoard.G6));
				  }
				}
			  }
			}
		  } else if (file.equals(File.FILE_G)) {
			if (lastMove.getFromField().equals(ChessBoard.F7) && lastMove.getToField().equals(ChessBoard.F5)) {
			  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
				testBoard = new ChessBoard(chessBoard);
				ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
				testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.F6), testBoard.get(ChessBoard.F5));
				if (!testBoard.checkForWhiteInCheck()) {
				  p.getNextFields().add(chessBoard.get(ChessBoard.F6));
				}
			  }
			}
		  }
		  if (lastMove.getFromField().equals(ChessBoard.H7) && lastMove.getToField().equals(ChessBoard.H5)) {
			if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			  testBoard = new ChessBoard(chessBoard);
			  ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			  testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.H6), testBoard.get(ChessBoard.H5));
			  if (!testBoard.checkForWhiteInCheck()) {
				p.getNextFields().add(chessBoard.get(ChessBoard.H6));
			  }
			}
		  }

		}
	  } else if (file.equals(File.FILE_H)) {
		if (lastMove.getFromField().equals(ChessBoard.G7) && lastMove.getToField().equals(ChessBoard.G5)) {
		  if (lastMove.getToField().getPiece() instanceof BlackPawn) {
			testBoard = new ChessBoard(chessBoard);
			ChessField fromField = testBoard.findByFileAndRow(p.getCurrentField().getFile(), p.getCurrentField().getRow());
			testBoard.moveEnPassant(fromField, testBoard.get(ChessBoard.G6), testBoard.get(ChessBoard.G5));
			if (!testBoard.checkForWhiteInCheck()) {
			  p.getNextFields().add(chessBoard.get(ChessBoard.G6));
			}
		  }

		}
	  }
	}
  }

  private void checkEnPassantBlack(Piece p) {
	log.info(p.getCurrentField().getRow().toString());
	if (p.getCurrentField().getRow().equals(Row.ROW_4)) {
	  File file = p.getCurrentField().getFile();
	  ChessMove lastMove = moves.getLast();
	  if (file.equals(File.FILE_A)) {
		if (lastMove.getFromField().equals(ChessBoard.B2) && lastMove.getToField().equals(ChessBoard.B4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.B3));
		  }
		}
	  } else if (file.equals(File.FILE_B)) {
		if (lastMove.getFromField().equals(ChessBoard.A2) && lastMove.getToField().equals(ChessBoard.A4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.A3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.C2) && lastMove.getToField().equals(ChessBoard.C4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.C3));
		  }
		}
	  } else if (file.equals(File.FILE_C)) {
		if (lastMove.getFromField().equals(ChessBoard.B2) && lastMove.getToField().equals(ChessBoard.B4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.B3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.D2) && lastMove.getToField().equals(ChessBoard.D4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.D3));
		  }
		}
	  } else if (file.equals(File.FILE_D)) {
		if (lastMove.getFromField().equals(ChessBoard.C2) && lastMove.getToField().equals(ChessBoard.C4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.C3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.E2) && lastMove.getToField().equals(ChessBoard.E4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.E3));
		  }
		}
	  } else if (file.equals(File.FILE_E)) {
		if (lastMove.getFromField().equals(ChessBoard.D2) && lastMove.getToField().equals(ChessBoard.D4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.D3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.F2) && lastMove.getToField().equals(ChessBoard.F4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.F3));
		  }
		}
	  } else if (file.equals(File.FILE_F)) {
		if (lastMove.getFromField().equals(ChessBoard.E2) && lastMove.getToField().equals(ChessBoard.E4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.E3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.G2) && lastMove.getToField().equals(ChessBoard.G4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.G3));
		  }
		}
	  } else if (file.equals(File.FILE_G)) {
		if (lastMove.getFromField().equals(ChessBoard.F2) && lastMove.getToField().equals(ChessBoard.F4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.F3));
		  }
		}
		if (lastMove.getFromField().equals(ChessBoard.H2) && lastMove.getToField().equals(ChessBoard.H4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.H3));
		  }
		}
	  } else if (file.equals(File.FILE_H)) {
		if (lastMove.getFromField().equals(ChessBoard.G2) && lastMove.getToField().equals(ChessBoard.G4)) {
		  if (lastMove.getToField().getPiece() instanceof WhitePawn) {
			p.getNextFields().add(chessBoard.get(ChessBoard.G3));
		  }
		}
	  }

	}
  }

  public boolean checkForStaleMate() {
	return false;
  }

  public boolean checkForCheckMate() {
	return false;
  }

  private boolean checkForCheck(ChessBoard board) {
	return (board.checkForBlackInCheck() || board.checkForWhiteInCheck());
  }

  public LinkedList<ChessMove> getMoves() {
	return moves;
  }

  public void setMoves(LinkedList<ChessMove> moves) {
	this.moves = moves;
  }
}

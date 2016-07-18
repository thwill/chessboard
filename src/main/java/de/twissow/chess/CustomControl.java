package de.twissow.chess;

import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class CustomControl extends Control {

	ChessBoardPresentation chessBoardPresentation = new ChessBoardPresentation();

	// Constructor
	public CustomControl() {
		setSkin(new CustomControlSkin(this));
		getChildren().add(chessBoardPresentation);
		showBoard();

		setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
			}
		});


		setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {

				int hashCode = event.getTarget().hashCode();
				if (event.getButton().equals(MouseButton.SECONDARY)) {
					chessBoardPresentation.handleMouseTargetClick(hashCode);
				}
				if (event.getButton().equals(MouseButton.PRIMARY)) {
					chessBoardPresentation.handleMouseSelectionClick(hashCode);
				}
				showBoard();
			}
		});

	}

	private void showBoard() {
		chessBoardPresentation.getChildren().clear();
		// Places background squares
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoardPresentation.placeBoard(i, j);
			}
		}
		// Places PieceImage
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				chessBoardPresentation.placeImage(i, j);
			}
		}
	}

}

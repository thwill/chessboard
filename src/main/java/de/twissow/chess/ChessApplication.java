package de.twissow.chess;

//imports
import java.io.PrintStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//class definition
public class ChessApplication extends Application {

	// private fields for this class
	private StackPane mainStackPane;

	private CustomControl cutomControl; // control which has a board and detects
										// mouse and keyboard events

	private TextArea status;

	@Override
	public void init() {
		mainStackPane = new StackPane();
		cutomControl = new CustomControl();
		mainStackPane.getChildren().add(cutomControl);
	}

	// overridden start method
	@Override
	public void start(Stage primaryStage) {

		// set the title and scene, and show the stage
		primaryStage.setTitle("Chess");
		primaryStage.setScene(new Scene(mainStackPane, 1000, 1000));
		// create text box

		TextArea status = new TextArea();
		status.setEditable(false);
		status.setPromptText("Notation");
		status.setStyle("-fx-font-size: 12;");
		status.setPrefWidth(200);
		status.setPrefHeight(800);
		PrintStream ps = System.out;
		System.setOut(new TextAreaPrintStream(status, ps));

		VBox vb = new VBox();
		vb.getChildren().add(status);
		vb.setPrefWidth(200);
		BorderPane bp = new BorderPane();

		primaryStage.setScene(new Scene(bp, 1000, 800));
		bp.setCenter(mainStackPane);
		bp.setRight(vb);

		primaryStage.setMaxHeight(830);
		primaryStage.setMinHeight(830);
		primaryStage.setMaxWidth(1000);
		primaryStage.setMinWidth(1000);

		primaryStage.show();
	}

	// overridden stop method
	@Override
	public void stop() {
	}

	public void appendToStatus(String Text) {
		status.appendText(Text);
	}

	public String getStatusText() {
		return status.getText();
	}

	// entry point into our program to launch our JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
}

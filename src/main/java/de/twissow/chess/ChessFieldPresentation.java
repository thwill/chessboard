package de.twissow.chess;

import de.twissow.chess.board.ChessField;
import de.twissow.chess.pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

public class ChessFieldPresentation {

    private static final int FIELD_SIZE = 100;

    private enum Colored {
        LIGHT, DARK;
    };

    private ImageView imageView;

    private Image image;

    private Rectangle rectangle;

    private ChessField field;

    private Colored colored = Colored.LIGHT;

    private boolean selected;

    private boolean target;



    public ChessFieldPresentation(ChessField field, boolean selected, boolean target) {
        this.field = field;
        this.selected = selected;
        this.target = target;
        drawField();
    }

    public ChessFieldPresentation(ChessField field) {
        this.field = field;
        selected =false;
        target = false;
        drawField();
    }

    private void drawField() {
        int fileCoordinate = this.field.getFile().getIndex();
        int rowCoordinate = this.field.getRow().getIndex();
        Piece piece;
        piece = this.field.getPiece();
        if (piece != null) {
            String imgName = piece.getClass().getSimpleName() + ".png";
            image = new Image(imgName);
        } else {
            image = new Image("Empty.png");
        }
        if ((fileCoordinate + rowCoordinate) % 2 != 0) {
            colored = Colored.DARK;
        }
        rectangle = new Rectangle(fileCoordinate * FIELD_SIZE, rowCoordinate * FIELD_SIZE, FIELD_SIZE, FIELD_SIZE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeType(StrokeType.INSIDE);

        if (colored == Colored.LIGHT) {
            rectangle.setFill(Color.WHITE);
        }
        if (colored == Colored.DARK) {
            rectangle.setFill(Color.CHOCOLATE);
        }
        if (isSelected()) {
            rectangle.setFill(Color.AQUAMARINE);
        }
        if (isTarget()) {
            rectangle.setFill(Color.CHARTREUSE);
        }


        imageView = new ImageView(image);
        imageView.setX(fileCoordinate * FIELD_SIZE);
        imageView.setY(rowCoordinate * FIELD_SIZE +  FIELD_SIZE / 10);
        imageView.setFitWidth(FIELD_SIZE - FIELD_SIZE / 4);
        imageView.setFitHeight(FIELD_SIZE - FIELD_SIZE / 4);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setTranslateX(rectangle.getWidth() / 8);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public ChessField getField() {
        return field;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

}

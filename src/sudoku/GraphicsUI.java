package sudoku;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import java.lang.*;

public class GraphicsUI extends Application {
	Button B = new Button("Solve");
	Button C = new Button("Clear");
	TilePane topbox = new TilePane();
	BorderPane root = new BorderPane();
	Sudoku solver = new Sudoku();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Sudoku");

		Board board1;
		root.setTop(topbox);
		HBox hbox = new HBox();
		root.setBottom(hbox);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(B, C);

		Scene scene = new Scene(root, 360, 385);

		topbox.setPrefColumns(9);
		topbox.setPrefRows(9);
		final int SIZE = 40;
		int counter = 0;
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				counter++;

				TextField label = new TextField();
				label.setAlignment(Pos.CENTER);
				label.setPrefSize(SIZE, SIZE);

				if (((k < 3 || k > 5) && (i < 3 || i > 5)) || ((i > 2 && i < 6) && (k > 2 && k < 6))) {
					label.setStyle("-fx-border-color : black;" + "-fx-font-size: 16;");

				} else {
					label.setStyle("-fx-background-color : pink;" + "-fx-border-color : black;" + "-fx-font-size: 16;");
				}
				topbox.getChildren().add(label);

			}
		}

		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		C.setOnAction(event -> {
			writeToWindow(clearWindow());

		});
		B.setOnAction(event -> {

			Board board = getFromWindow();
			if (solver.solve(board)) {
				
				writeToWindow(board);
				
			}
				else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error Dialog");
					alert.setHeaderText("Sudoku Error");
					alert.setContentText("Sudoku unsolvable");

					alert.showAndWait();

				}
			

			/*
			 * else{
			 * 
			 * 
			 * }
			 */

			// TextField label = (TextField) topbox.getChildren().get(0);
			// System.out.println(label.getText().toCharArray());

			// läsa in alla inputs i en array
			// sedan skall denna översättas till barnen i topboxen

		});

	}

	public Board getFromWindow() {
		int value;
		int[] array = new int[81];
		String text;
		for (int i = 0; i < 81; i++) {
			TextField label = (TextField) topbox.getChildren().get(i);
			// TODO: felinmatning
			// när ruta ej inmatad
			text = label.getText();
			if (text.equals("")) {
				value = 0;

			} else {
				value = Integer.parseInt(label.getText());
			}

			array[i] = value;

		}
		Board board = new Board();
		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {
				// TODO; hantera felinmatade
				board.set(k, i, array[index]);
				index++;
			}
		}
		return board;
	}

	public boolean writeToWindow(Board board) {

		int index = 0;
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				TextField label = (TextField) topbox.getChildren().get(index);

				label.setText(Integer.toString(board.get(x, y)));
				index++;
			}
		}

		return false;
	}

	public Board clearWindow() {
		Board clearBoard = new Board();

		return clearBoard;
	}
}


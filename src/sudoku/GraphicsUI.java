package sudoku;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class GraphicsUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("SudokuSolver");

		Button B = new Button("Solve");
		Button C = new Button("Clear");
		TilePane topbox = new TilePane();
		BorderPane root = new BorderPane();
		root.setTop(topbox);
		HBox hbox = new HBox();
		root.setBottom(hbox);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.getChildren().addAll(B, C);

		Scene scene = new Scene(root, 360, 385);

		topbox.setPrefColumns(9);
		topbox.setPrefRows(9);
		final int SIZE = 40;
		for (int i = 0; i < 9; i++) {
			for (int k = 0; k < 9; k++) {

				TextField label = new TextField();
				label.setAlignment(Pos.CENTER);
				label.setPrefSize(SIZE, SIZE);
				topbox.getChildren().add(label);
			}
		}
		
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

	}
}

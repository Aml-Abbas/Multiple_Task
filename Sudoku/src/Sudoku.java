import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Sudoku extends Application {
    
	private static Matris matrix= new Matris();
	private static TextField[][] textFields = new TextField[9][9];

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();

		TilePane tilePane = new TilePane();

		tilePane.setPrefRows(9);
		tilePane.setPrefColumns(9);

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				textFields[i][j] = new TextField();
				TextFieldUtils.textLimiter(textFields[i][j], 1);
				textFields[i][j].setPrefColumnCount(1);
				tilePane.getChildren().add(textFields[i][j]);

				if (((i == 0 || i == 1 || i == 2 || i == 6 || i == 7 || i == 8)
						&& (j == 0 || j == 1 || j == 2 || j == 6 || j == 7 || j == 8))
						|| ((i == 3 || i == 4 || i == 5) && (j == 3 || j == 4 || j == 5))) {
					textFields[i][j].setStyle("-fx-border-color: pink;");

				}
			}
		}

		Button solveButton = new Button("Solve");
		Button clearButton = new Button("Clear");
		Button fillButton = new Button("fill");
		solveButton.setOnAction(e -> {

			for (int i = 0; i < textFields.length; i++) {
				for (int j = 0; j < textFields.length; j++) {
					String text = textFields[i][j].getText();
					if (!text.equals("")) {
						int value = Integer.parseInt(text);
                        
						matrix.add(i, j, value);
					}
					else {
						matrix.add(i, j, 0);
					}
				}
			}
			matrix.print();
			
			if(matrix.solve()) {

				showBorderPane();
				matrix.print();
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("OBS:");
				alert.setContentText("This Sudoku cann't be solved");
				alert.show();
			}
            
		});

		clearButton.setOnAction(e -> {
			clearBorderPane();
             
		});
		fillButton.setOnAction(e -> {
		
			clearBorderPane();
            matrix.fillRandomly();
            showBorderPane();
		});

		HBox hbox = new HBox();
		hbox.getChildren().addAll(solveButton, clearButton,fillButton);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setSpacing(20);

		Scene scene = new Scene(root);
		root.setCenter(tilePane);
		root.setBottom(hbox);

		stage.setTitle("Sudoku");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * ta bort alla element som finns i matris och visa matrisen igen på fönstret.
	 */
	public static void clearBorderPane() {
		 matrix.clear();
         for (int i = 0; i < textFields.length; i++) {
				for (int j = 0; j < textFields.length; j++) {
					textFields[i][j].setText("");
				
				}
			}
	}
	
	/**
	 * visa det som finns i matris på fönstret.
	 */
	
	public static void showBorderPane() {
		 
		   for (int i = 0; i < textFields.length; i++) {
				for (int j = 0; j < textFields.length; j++) {
					if(matrix.get(i, j)!=0) {
						textFields[i][j].setText(String.valueOf(matrix.get(i, j)));
						
					}
					
				}
			}
	}

}

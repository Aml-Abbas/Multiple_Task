import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class Sudoku extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		
		TilePane tile = new TilePane();
		
		tile.setPrefRows(9);
		tile.setPrefColumns(9);
		
		for(int i=0; i<9;i++) {
			for(int j=0; j<9;j++) {
				TextField textField=new TextField();
		        tile.getChildren().add(textField);

		      if(((i==0||i==1||i==2||i==6||i==7||i==8)&&(j==0||j==1||j==2||j==6||j==7||j==8))||((i==3||i==4||i==5)&&(j==3||j==4||j==5))) {
		     textField.setStyle( "-fx-border-color: black;");
		    	 
		    	  
		      }
			}
		}
		
		
		Button button1= new Button("Solve");
		Button button2= new Button("Clear");
		HBox hbox= new HBox();
		hbox.getChildren().addAll(button1, button2);
		
		Scene scene = new Scene(root);
		root.setCenter(tile);
		root.setBottom(hbox);
		stage.setTitle("Sudoku");
		stage.setScene(scene);
        stage.show();
	}

	public static void main(String[] args) {   
		launch(args);    
		}
	
}

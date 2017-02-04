package cellsociety_team06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import subUnits.Blank;

public abstract class Model {
	
	private Unit[][] currentGrid = new Unit[10][10];
	private Unit[][] nextGrid = new Unit[10][10];
	private Stage myStage;
	private Timeline animation;
	private int width = 500;
	private int height = 500;
	
	//constructor
	public Model (Stage s, Timeline t){
		myStage = s;
		animation = t;
	}
	
	//methods
	
	public abstract Scene getNextScene(); //creates the scene with the new units
	
	public abstract void setNextScene(); //within the subclasses, there will be a current scene and next scene
	
	private Unit[][] getCurrentGrid(){
		return currentGrid;
	}
	
	private Unit[][] getNextGrid(){
		return nextGrid;
	}
	
	public void step(){
		getNextScene();
	}
	
	public Button createHowToPlayBtn(String instr, Scene lastScene){ //pass in the text file of the rules and current scene to go back to
		
		Pane rulesRoot = new Pane();
		Scene rulesScene = new Scene(rulesRoot);
		
		Button btn_howToPlay = new Button("How to play");
		btn_howToPlay.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent arg){
				
				Text tx_instr = new Text(instr);
				try (Scanner scanner = new Scanner(new File(instr))){
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine() + "\n";
						tx_instr.setText(tx_instr.getText()+ line);
					}
					rulesRoot.getChildren().add(tx_instr);
					System.out.print(tx_instr);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				Button btn_done = new Button("Done");
				btn_howToPlay.setOnAction(new EventHandler<ActionEvent>() { 
					public void handle(ActionEvent arg){
						myStage.setScene(lastScene);
					}
				});
				
				rulesRoot.getChildren().addAll(tx_instr, btn_done);
				myStage.setScene(rulesScene);

			}
		});
		
		return btn_howToPlay;
	}
	
	public Button createStartSimBtn(){
		
		Button btn_start = new Button("Start Simulation");
		btn_start.setOnAction(new EventHandler<ActionEvent>() { //if the button is clicked
			public void handle(ActionEvent arg){
				animation.play();
			}
		});
		
		return btn_start;
	}
	
	public Button createPauseBtn(){
		
		Button btn_pause = new Button("Pause");
		btn_pause.setOnAction(new EventHandler<ActionEvent>() { //if the button is clicked
			public void handle(ActionEvent arg){
				animation.pause();
			}
		});
		
		return btn_pause;
		
	}
	
	public Button createResetBtn(){
		
		Button btn_reset = new Button("Reset");
		btn_reset.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent arg){
				for (int i=0; i<currentGrid.length; i++){
					for (int j=0; j<currentGrid[i].length; j++){
						nextGrid[i][j] = new Blank((width * i)/10, (height * j)/10, width/10, height/10);
					}
				}
				setNextScene();
			}
		});
		
		return btn_reset;
	}
	
}
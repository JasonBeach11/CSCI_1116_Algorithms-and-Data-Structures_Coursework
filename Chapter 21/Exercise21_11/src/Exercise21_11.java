/**
 * @author Jason Beach
 * @Date May 4, 2023
 * CSCI 1116: Algorithms and Data Structures
 * Exercise 21-11: Baby Name Popularity Ranking
 * This program ranks the top 1000 popular baby names from 2001 to 2010. The user inputs the name
 * they are interested in searching, selects year and gender from drop downs, and the program 
 * displays the popularity ranking of the name.
 * */

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];

  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    GridPane gridPane = new GridPane();
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    for (int year = 2001; year <= 2010; year++) {
        cboYear.getItems().add(year);
      }
      cboYear.setValue(2001);
          
      cboGender.getItems().addAll("Male", "Female");
      cboGender.setValue("Male");
    
    // Read data into Hash Maps  
    for (int i = 0; i < 10; i++) {
        mapForBoy[i] = new HashMap<>();
        mapForGirl[i] = new HashMap<>();
        
        try (Scanner scanner = new Scanner(new URL("http://liveexample.pearsoncmg.com/data/babynamesranking"+(2001+i)+".txt").openStream(), "UTF-8")) {
        	while (scanner.hasNextLine()) {
        		String line = scanner.nextLine();
        		String[] data = line.split("\\s+");
        		int ranking = Integer.parseInt(data[0]);
        		String boysName = data[1];
        		int boysCount = Integer.parseInt(data[2]);
        		String girlsName = data[3];
        		int girlsCount = Integer.parseInt(data[4]);

        		mapForBoy[i].put(boysName, ranking);
        		mapForGirl[i].put(girlsName, ranking);
        	}
        } 
        catch (IOException ex) {
        	System.out.println("IO Exception");
        }
    }
    
    // Display the results when "Find Ranking" button is clicked
    btFindRanking.setOnAction(e -> {
    	int year = cboYear.getValue();
        String gender = cboGender.getValue().equals("Male") ? "M" : "F";
        String name = tfName.getText();
        
        // Call findRanking method
        int ranking = findRanking(year, gender, name);
        
        if (ranking < 0) {
            lblResult.setText("The name \"" + name + "\" is not ranked in the top 1000 names for " + year + ".");
        } 
        else {
            lblResult.setText(name + " is ranked #" + ranking + " among " + gender.toLowerCase() + " names in the year " + year + ".");
        }
    });
  }
  
  /** Finds the rank of a male or female name */
  public int findRanking(int year, String gender, String name) {
	    int ranking = -1; // initialize ranking to -1 as a default value
	    
	    // determine the index of the map for the given year
	    int mapIndex = year - 2001;
	    
	    // determine the map to use based on the gender
	    Map<String, Integer>[] maps = (gender.equalsIgnoreCase("M")) ? mapForBoy : mapForGirl;
	    Map<String, Integer> map = maps[mapIndex];
	    
	    // find the ranking for the given name in the map
	    if (map.containsKey(name)) {
	        ranking = map.get(name);
	    }
	    return ranking;
	}
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

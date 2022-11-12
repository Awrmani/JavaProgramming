/**********************************************
Workshop #6
Course: JAC444 - Semester Winter 2022
Last Name: Valaee Asr
First Name: Arman
ID: 139550206
Section: ZBB
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature A.V.A
Date: 2022-3-22
**********************************************/

package task1;

import java.io.*;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class BabyName extends Application {
	String fileName = null;
	String text = null, line[];
	String boyName[] = new String[1000], girlName[] = new String[1000];
	int rank[] = new int[1000];
	int boyCNT[] = new int[1000], girlCNT[] = new int[1000];
	char gen = ' ';
	
	
	void readFile(String fileName) {
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    text = sb.toString().trim().replace("\t", " ");
		    text = text.replace(",", "");
		    text = text.replaceAll(" +", " ");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		// Load Variables with Information
		line = text.split(System.getProperty("line.separator"));
		text = text.toLowerCase();
		try
		{
			for (int i = 0; i < 1000; ++i) {
				String token[];
				token = line[i].split(" ");
				rank[i] = Integer.valueOf(token[0]);
				boyName[i] = token[1];
				boyCNT[i] = Integer.valueOf(token[2]);
				girlName[i] = token[3];
				girlCNT[i] = Integer.valueOf(token[4]);
			}
		}
		catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
	
	int getRank(String name, char gender) {
		int rnk = -1;
		boolean found = false;
		if (gender == 'm') {
			for (int i = 0; i < 1000 && !found; ++i)
				if (boyName[i].toLowerCase().equals(name)) {
					rnk = rank[i];	
					found = true;
				}
		}
		else if (gender == 'f') {
			for (int i = 0; i < 1000 && !found; ++i) 
				if (girlName[i].toLowerCase().equals(name)) {
					rnk = rank[i];
					found = true;
				}
		}
		return rnk;
	}
	
	String displayMsg(String name, char gender, int rank, int year) {
		String msg = null;
		char first = name.toUpperCase().charAt(0);
		String fname = name.toLowerCase().substring(1);
		if (rank != -1) {
			if (gender == 'm')
				msg = "Boy name ";
			else
				msg = "Girl name ";
			
			msg += first + fname + " is ranked #" + rank + " in " + year;	
		}
		else
			msg = first + fname + " name does not exist in the records!";
		
		return msg;
	}

	@Override 
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
	    pane.setAlignment(Pos.CENTER);
	    pane.setPadding(new Insets(10, 10, 10, 10));
	    pane.setVgap(10);
	    
	    FlowPane year = new FlowPane();
	    year.setHgap(25);
	    TextField tYear = new TextField();
	    tYear.setPrefColumnCount(10);
	    year.getChildren().addAll(new Label("Enter the Year:"),
	    		tYear);
	    year.setAlignment(Pos.CENTER);
	    
	    FlowPane gender = new FlowPane();
	    gender.setHgap(10);
	    TextField tGender = new TextField();
	    tGender.setPrefColumnCount(1);
	    gender.getChildren().addAll(new Label("Enter the Gender:"),
	    		tGender);
	    gender.setAlignment(Pos.CENTER);
	    
	    FlowPane name = new FlowPane();
	    name.setHgap(18);
	    TextField tName = new TextField();
	    tName.setPrefColumnCount(10);
	    name.getChildren().addAll(new Label("Enter the Name:"),
	    		tName);
	    name.setAlignment(Pos.CENTER);
	    
	    HBox buttons = new HBox(7);
	    Button btSubmit = new Button("Submit Query");
	    Button btExit = new Button("Exit");
	    
	    buttons.getChildren().addAll(btSubmit, btExit);
	    buttons.setAlignment(Pos.CENTER);
	    
	    
	    pane.add(year, 0, 0);
	    pane.add(gender, 0, 1);
	    pane.add(name, 0, 2);
	    pane.add(buttons, 0, 4);
	    
	    Scene scene = new Scene(pane);
	    primaryStage.setTitle("Seach Name Ranking Application"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    // Pane 2
	    GridPane pane2 = new GridPane();
	    pane2.setAlignment(Pos.CENTER);
	    pane2.setPadding(new Insets(10, 10, 10, 10));
	    pane2.setVgap(10);
	    Scene scene2 = new Scene(pane2);
	    
	    Label message = new Label("");
	    GridPane.setHalignment(message, javafx.geometry.HPos.CENTER);
	    
	    Label prompt = new Label("Do you want to Search for another Name:");
	    GridPane.setHalignment(prompt, javafx.geometry.HPos.CENTER);
	    
	    HBox buttons2 = new HBox(7);
	    Button btYes = new Button("Yes");
	    Button btNo = new Button("No");
	    
	    buttons2.getChildren().addAll(btYes, btNo);
	    buttons2.setAlignment(Pos.CENTER);
	    
	    pane2.add(message, 0, 0);
	    pane2.add(prompt, 0, 2);
	    pane2.add(buttons2, 0, 3);
	    
	    btSubmit.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	    	public void handle(ActionEvent e) {
	    		boolean found = false;
	    		String msg = null;
	    		try {
	    			if (Integer.valueOf(tYear.getText()) > 2008 && Integer.valueOf(tYear.getText()) < 2019) {
	    				fileName = "babynamesranking" + tYear.getText() + ".txt";
	    				readFile(fileName);
	    				//tName.setText(fileName);
	    				
	    				gen = tGender.getText().toLowerCase().charAt(0);
	    				if (gen == 'm' || gen == 'f') {
	    					gen = tGender.getText().toLowerCase().charAt(0);
	    					int rnk = getRank(tName.getText().toLowerCase(), gen);
	    					msg =  displayMsg(tName.getText(), gen, rnk, Integer.valueOf(tYear.getText()));
	    					found = true;
	    				}
	    				else
	    				{
	    					message.setText("Invalid Gender Input! Please Enter M or F.");
	    					gen = ' ';
	    				}
	    			}
	    			else
	    				message.setText("Invalid Year Input! Please Enter between 2009 and 2018.");		
	    		}
	    		catch (NumberFormatException ex){
	    			ex.printStackTrace();
	    		}
	    		
	    		if (found) {
	    			message.setText(msg);
	    		}
	    		
	    	    primaryStage.setScene(scene2); // Place the scene in the stage
	    	}
	    });
	    
	    btExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Platform.exit();
			}
	    });
	    
	    btYes.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				tYear.setText("");
				tGender.setText("");
				tName.setText("");
				primaryStage.setScene(scene); // Place the scene in the stage
			}
	    });
	    
	    btNo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Platform.exit();
			}
	    });
	}
	  
	public static void main(String[] args) {
		launch(args);
	}
}
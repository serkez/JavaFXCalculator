package com.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

import java.util.Objects;

/*
* Naomi Serkez
* April 15th, 2024
*/
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			//sets the stage and loads everything up
			GridPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calculator.fxml")));
			Scene scene = new Scene(root,453,590);
			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("CALCULATOR");
			primaryStage.show();
		}
		 catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

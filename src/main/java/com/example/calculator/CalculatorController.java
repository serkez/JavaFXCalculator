package com.example.calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * Naomi Serkez
 * April 15th, 2024
 */
//creates the logic for the calculator
public class CalculatorController { //the setters are purely for the sake of junit
	private double number1 ;
	public void setNumber1(double n){
		number1 = n;
	}
	private double number2 ;
	public void setNumber2(double n){
		number2 = n;
	}
	private String currOperation = "";
	public void setCurrOperation(String op){
		currOperation = op;
	}
	boolean first = true;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button buttonClear;

	@FXML
	private Button buttonDivide;

	@FXML
	private Button buttonEight;

	@FXML
	private Button buttonEquals;

	@FXML
	private Button buttonFive;

	@FXML
	private Button buttonFour;

	@FXML
	private Button buttonMinus;

	@FXML
	private Button buttonNine;

	@FXML
	private Button buttonOne;

	@FXML
	private Button buttonPlus;

	@FXML
	private Button buttonSeven;

	@FXML
	private Button buttonSix;

	@FXML
	private Button buttonThree;

	@FXML
	private Button buttonTimes;

	@FXML
	private Button buttonTwo;

	@FXML
	private Button buttonZero;

	@FXML
	private Label resultLabel;

	//where the 'magic' happens
	//calls different methods, functions based on which button was pressed
	@FXML
	void actionButton(ActionEvent event) {
		System.out.println(event.getSource().toString());
		Button button = (Button)event.getSource();
		String buttonText = button.getText();
		if(resultLabel.getText().equals("0.0"))
			resultLabel.setText(""); //clears the default value
		//if user clicked an operator, calls operationButton()
		if(buttonText.equals("=")||buttonText.equals("+")||buttonText.equals("-")||buttonText.equals("÷")||buttonText.equals("×")||buttonText.equals("C"))
			operationButton(buttonText);
		//otherwise, edits the value of the text field to include the number they pressed
		else {
			if(first) { //checks whether its the number before or after the operator
				resultLabel.setText(resultLabel.getText() + buttonText);
				int num = Integer.parseInt(buttonText);
				if(number1 == 0)
					number1 = num;
				else
					number1 =Integer.parseInt((int)number1 + "" + num);

			}
			else {
				resultLabel.setText(resultLabel.getText() + buttonText);
				int num = Integer.parseInt(buttonText);
				if(number2 == 0)
					number2 = num;
				else
					number2 =Integer.parseInt((int)number2 + "" + num);

			}
		}

	}
	// sets num1 to the result, num2 to 0, and resets first to true
	void operationButton(String operation) {
		if(operation.equals("=")) {
			resultLabel.setText(result() + "");
			number1 = result();
			number2 = 0;
			first = true;
		}
		else if (operation.equals("C")) { //clears everything out
			number1 = 0;
			number2 = 0;
			resultLabel.setText("0.0");
			first = true;
		}
		else { //for math operators...
			if(number2 != 0){
				number1 = result();
				number2 = 0;
			}
			currOperation = operation;
			first = false;
			resultLabel.setText(resultLabel.getText() + currOperation);
		}
	}
	//here is where the math happens
	//set to public for test file to use, not ideal
	public double result() {
		switch (currOperation) {
        case "+":
            return number1 + number2;
        case "-":
            return number1 - number2;
        case "÷":
            return number1 / number2;
        case "×":
            return number1 * number2;

		default:
			throw new IllegalStateException("Invalid operator: " + currOperation);
		}
	}

	@FXML
	void initialize() {
		assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonDivide != null
				: "fx:id=\"buttonDivide\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonEight != null : "fx:id=\"buttonEight\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonEquals != null
				: "fx:id=\"buttonEquals\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonFive != null : "fx:id=\"buttonFive\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonFour != null : "fx:id=\"buttonFour\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonMinus != null : "fx:id=\"buttonMinus\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonNine != null : "fx:id=\"buttonNine\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonOne != null : "fx:id=\"buttonOne\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonPlus != null : "fx:id=\"buttonPlus\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonSeven != null : "fx:id=\"buttonSeven\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonSix != null : "fx:id=\"buttonSix\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonThree != null : "fx:id=\"buttonThree\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonTimes != null : "fx:id=\"buttonTimes\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonTwo != null : "fx:id=\"buttonTwo\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert buttonZero != null : "fx:id=\"buttonZero\" was not injected: check your FXML file 'Calculator.fxml'.";
		assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'Calculator.fxml'.";
		resultLabel.setText("0.0");

	}

}

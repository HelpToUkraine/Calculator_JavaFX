package com.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    private long num1;
    private long num2;
    private boolean start = true;
    private String operator = "";

    @FXML
    private TextField text_result;

    @FXML
    void onNumberClickButton(ActionEvent event) {
        final String numberButton = ((Button) event.getSource()).getText();
        if (operator.equals("")) {
            if (num1 == 0 || !start)
                text_result.setText(numberButton);
            else
                text_result.setText(text_result.getText() + numberButton);
            num1 = Long.parseLong(text_result.getText());

        } else {
            num2 = Long.parseLong(num2 + numberButton);
            text_result.setText(num1 + operator + num2);
        }
    }

    @FXML
    void onOperatorClickButton(ActionEvent event) {
        if (operator.equals("")) {
            operator = ((Button) event.getSource()).getText();
            text_result.setText(text_result.getText() + operator);
        } else {
            calculate(num1, num2, operator);
            try {
                num1 = Long.parseLong(text_result.getText());
            } catch (Exception ignored) {
                num1 = 0;
            }
            num2 = 0;
            operator = "";
            start = false;
        }
    }

    @FXML
    void onClearClickButton() {
        text_result.setText("");
        num1 = 0;
        num2 = 0;
        operator = "";
        start = true;
    }

    private void calculate(long num1, long num2, String operator) {
        switch (operator) {
            case "+" -> text_result.setText(String.valueOf(num1 + num2));
            case "-" -> text_result.setText(String.valueOf(num1 - num2));
            case "*" -> text_result.setText(String.valueOf(num1 * num2));
            case "/" -> {
                if (num2 == 0)
                    text_result.setText("Ділення на 0!");
                else
                    text_result.setText(String.valueOf(num1 / num2));
            }
        }
    }


}

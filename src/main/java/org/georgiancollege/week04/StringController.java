package org.georgiancollege.week04;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StringController implements Initializable {
    @FXML
    private TextField phoneNumTextField;

    @FXML
    private Label resultLabel;

    @FXML
    private Label noSpaceLabel;

    @FXML
    private Label formattedLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am in initialize method - in my string controller.");

        // string class
        String string1 = new String("Hello! How are you?");
        String string2 = "Hello! How are you?";

        // using ==
        if(string1 == string2){
            System.out.println("Both the strings are equal.");
        } else {
            System.out.println("Both the strings are not equal.");
        }

        // using equals method
        if(string1.equals(string2)){
            System.out.println("Both the strings are equal.");
        } else {
            System.out.println("Both the strings are not equal.");
        }

        // string builder
        StringBuilder sb1 = new StringBuilder("ABCD");
        System.out.println("Previous sb1 value: " + sb1);
        sb1.append("XYZ");
        System.out.println("New sb1 value:" + sb1);
    }

    @FXML
    void manipulatePhoneNum(ActionEvent event) {
        System.out.println("Submit Button Clicked!");

        // store the user input in a string variable
        String phoneNum = phoneNumTextField.getText();
        System.out.println(phoneNum);

        // check if the number is following the correct
        // north american dialing plan (regex) or not
        if(phoneNum.matches("\\(?[2-9][0-9][0-9]\\)?[-.\\s]?[2-9]\\d{2}[-.\\s]?\\d{4}")){ // (705) 334-1234
            resultLabel.setText(phoneNum + " follows the dialing plan.");
        } else{
            resultLabel.setText(phoneNum + " does not follow the dialing plan.");
        }

        // convert the provided phone number to a sanitized string
        // so that this can be stored in a database
        String noSpaceString = phoneNum.replaceAll("[-.\\s\\(\\)]", "");
        noSpaceLabel.setText(noSpaceString); // 7053341234

        // if the string is 10 digits - format the string to (XXX) XXX-XXXX
        if(noSpaceString.length() == 10){
            String areaCode = noSpaceString.substring(0, 3);
            String secondPart = noSpaceString.substring(3, 6);
            String lastPart = noSpaceString.substring(6);
            formattedLabel.setText(String.format("(%s) %s-%s", areaCode, secondPart, lastPart));
        }
    }
}

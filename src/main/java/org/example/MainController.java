package org.example;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

import java.awt.event.InputMethodEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private ComboBox<String> Comb1;

    @FXML
    private ComboBox<String> Comb2;

    @FXML
    private Button ConvertirBtn;

    @FXML
    private TextField TextFailed1;

    @FXML
    private TextField TextFailed2;

    public void convertBinary(String binaryInput, String baseString) {

        int decimal = 0;

        switch (baseString) {
            case "octal":
                // Convert binary to decimal
                decimal = Integer.parseInt(binaryInput, 2);

                // Convert decimal to octal
                String octalOutput = Integer.toOctalString(decimal);
                TextFailed2.setText(octalOutput);
                break;

            case "decimal":
                // Convert binary to decimal
                decimal = Integer.parseInt(binaryInput, 2);
                String decimalOutput = Integer.toString(decimal);
                TextFailed2.setText(decimalOutput);
                break;

            case "hexadecimal":
                decimal = Integer.parseInt(binaryInput, 2);

                // Convert decimal to hexadecimal
                String hexOutput = Integer.toHexString(decimal).toUpperCase();
                TextFailed2.setText(hexOutput);
                break;

            default:
                break;
        }
    }

    public void convertDecimal(String decimalInput, String baseString) {

        int decimal =  Integer.parseInt(decimalInput);

        switch (baseString) {
            case "octal":
                // Convert decimal to octal
                String octalOutput = Integer.toOctalString(decimal);
                TextFailed2.setText(octalOutput);
                break;

            case "binary":
                String binaryOutput = Integer.toBinaryString(decimal);
                TextFailed2.setText(binaryOutput);
                break;

            case "hexadecimal":
                // Convert decimal to hexadecimal
                String hexOutput = Integer.toHexString(decimal).toUpperCase();
                TextFailed2.setText(hexOutput);
                break;

            default:
                break;
        }
    }

    public void convertOctal(String octalInput, String baseString) {

        int decimalOutput = Integer.parseInt(octalInput, 8);

        switch (baseString) {
            case "decimal":

                String decimal = Integer.toString(decimalOutput);
                TextFailed2.setText(decimal);
                break;

            case "binary":
                // Convert decimal to binary
                String binaryOutput = Integer.toBinaryString(decimalOutput);
                TextFailed2.setText(binaryOutput);
                break;

            case "hexadecimal":
                // Convert decimal to hexadecimal
                String hexOutput = Integer.toHexString(decimalOutput).toUpperCase();
                TextFailed2.setText(hexOutput);
                break;

            default:
                break;
        }
    }

    public void convertHexadecimal(String hexadecimalInput, String baseString) {

        int decimalOutput = Integer.parseInt(hexadecimalInput, 16);

        switch (baseString) {
            case "decimal":

                String decimal = Integer.toString(decimalOutput);
                TextFailed2.setText(decimal);
                break;

            case "binary":
                // Convert decimal to binary
                String binaryOutput = Integer.toBinaryString(decimalOutput);
                TextFailed2.setText(binaryOutput);
                break;

            case "octal":
                // Convert decimal to octal
                String octalOutput = Integer.toOctalString(decimalOutput);
                TextFailed2.setText(octalOutput);
                break;

            default:
                break;
        }
    }

    public void convert(String mainBase, String secondaryBase, String input) {
        switch (mainBase) {
            case "binary":
                convertBinary(input, secondaryBase);
                break;

            case "decimal":
                convertDecimal(input, secondaryBase);
                break;

            case "octal":
                convertOctal(input, secondaryBase);
                break;

            case "hexadecimal":
                convertHexadecimal(input, secondaryBase);
                break;

            default:
                break;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Bases = FXCollections.observableArrayList(
                "binary",
                "decimal",
                "hexadecimal",
                "octal"
        );

        Comb1.setItems(Bases);
        Comb2.setItems(Bases);
    }

    String Fromm = "binary";
    String Too = "decimal";

    public void Action(ActionEvent event) {
        Fromm = Comb1.getSelectionModel().getSelectedItem().toString();
    }

    public void Comb2OnAction(ActionEvent event) {
        Too = Comb2.getSelectionModel().getSelectedItem().toString();
    }

    public void OnMouseClicked(MouseEvent mouseEvent) {
        String input = TextFailed1.getText();
        System.out.println("input: "+input);
        System.out.println("from: "+Fromm);
        System.out.println("Too: "+Too);
        convert(Fromm, Too, input);
    }
}
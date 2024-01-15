package org.example;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    public ComboBox<String> Comb1;

    @FXML
    public ComboBox<String> Comb2;

    @FXML
    private Button ConvertirBtn;

    @FXML
    public TextField TextFailed1;

    @FXML
    protected TextField TextFailed2;

    public String convertBinary(String binaryInput, String baseString) {

        int decimal = 0;

        if (baseString.equals("octal")) {
            // Convert binary to decimal
            decimal = Integer.parseInt(binaryInput, 2);

            // Convert decimal to octal
            String octalOutput = Integer.toOctalString(decimal);
            // TextFailed2.setText(octalOutput);
            return octalOutput;
        }

        if (baseString.equals("decimal")) {
            // Convert binary to decimal
            decimal = Integer.parseInt(binaryInput, 2);
            String decimalOutput = Integer.toString(decimal);
            // TextFailed2.setText(decimalOutput);
            return  decimalOutput;
        }

        if (baseString.equals("hexadecimal")) {
            decimal = Integer.parseInt(binaryInput, 2);

            // Convert decimal to hexadecimal
            String hexOutput = Integer.toHexString(decimal).toUpperCase();
            // TextFailed2.setText(hexOutput);
            return hexOutput;
        }

        return null;
    }

    public String convertDecimal(String decimalInput, String baseString) {

        int decimal =  Integer.parseInt(decimalInput);

        if (baseString.equals("octal")) {
            // Convert decimal to octal
            String octalOutput = Integer.toOctalString(decimal);
            // TextFailed2.setText(octalOutput);
            return octalOutput;
        }

        if (baseString.equals("binary")) {
            String binaryOutput = Integer.toBinaryString(decimal);
            // TextFailed2.setText(binaryOutput);
            return  binaryOutput;
        }

        if (baseString.equals("hexadecimal")) {
            // Convert decimal to hexadecimal
            String hexOutput = Integer.toHexString(decimal).toUpperCase();
            // TextFailed2.setText(hexOutput);
            return hexOutput;
        }

        return null;
    }

    public String convertOctal(String octalInput, String baseString) {

        int decimalOutput = Integer.parseInt(octalInput, 8);

        if (baseString.equals("decimal")) {
            String decimal = Integer.toString(decimalOutput);
            // TextFailed2.setText(decimal);
            return decimal;
        }

        if (baseString.equals("binary")) {
            // Convert decimal to binary
            String binaryOutput = Integer.toBinaryString(decimalOutput);
            // TextFailed2.setText(binaryOutput);
            return  binaryOutput;
        }

        if (baseString.equals("hexadecimal")) {
            // Convert decimal to hexadecimal
            String hexOutput = Integer.toHexString(decimalOutput).toUpperCase();
            // TextFailed2.setText(hexOutput);
            return  hexOutput;
        }

        return null;
    }

    public String convertHexadecimal(String hexadecimalInput, String baseString) {

        int decimalOutput = Integer.parseInt(hexadecimalInput, 16);

        if (baseString.equals("decimal")) {
            String decimal = Integer.toString(decimalOutput);
            // TextFailed2.setText(decimal);
            return  decimal;
        }

        if (baseString.equals("binary")) {
            // Convert decimal to binary
            String binaryOutput = Integer.toBinaryString(decimalOutput);
            // TextFailed2.setText(binaryOutput);
            return binaryOutput;
        }

        if (baseString.equals("octal")) {
            // Convert decimal to octal
            String octalOutput = Integer.toOctalString(decimalOutput);
            // TextFailed2.setText(octalOutput);
            return  octalOutput;
        }

        return null;
    }

    public void convert(String mainBase, String secondaryBase, String input) {

        String Output;

        if (mainBase.equals("binary")) {
            Output = convertBinary(input, secondaryBase);
            TextFailed2.setText(Output);
        }

        if (mainBase.equals("decimal")) {
            Output = convertDecimal(input, secondaryBase);
            TextFailed2.setText(Output);
        }

        if (mainBase.equals("octal")) {
            Output = convertOctal(input, secondaryBase);
            TextFailed2.setText(Output);
        }

        if (mainBase.equals("hexadecimal")) {
            Output = convertHexadecimal(input, secondaryBase);
            TextFailed2.setText(Output);
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
        convert(Fromm, Too, input);
    }
}
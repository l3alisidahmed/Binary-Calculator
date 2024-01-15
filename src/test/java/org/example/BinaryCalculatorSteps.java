package org.example;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class BinaryCalculatorSteps {
    private MainController main = new MainController();
    private String binaryInput;
    private String octalInput;
    private String baseString;
    private String result;

    @Given("^binary input \"([^\"]*)\"$")
    public void binaryInput(String binaryInput) {
        this.binaryInput = binaryInput;
    }

    @When("^converted to octal$")
    public void convertToOctal() {
        result = main.convertBinary(binaryInput, "octal");
    }

    @Then("^the converted result should be \\\"([^\\\"]*)\\\"$")
    public void theResultShouldBe66(String expectedOutput) {
        assertEquals(expectedOutput, result);
    }

    @Given("^octal input \\\"([^\\\"]*)\\\"$")
    public void OctalInput(String octalInput) {
        this.octalInput = octalInput;
    }

    @When("^converted to binary$")
    public void convertToBinary() {
        result = main.convertOctal(octalInput, "binary");
    }

    @Then("^the result should be \"([^\"]*)\"$")
    public void theResultShouldBe111(String expectedOutput) {
        assertEquals(expectedOutput, result);
    }

}


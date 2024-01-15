package org.example;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class BinaryCalculatorSteps {
    private MainController main = new MainController();
    private String binaryInput;
    private String baseString;
    private String result;

    @Given("^binary input \"([^\"]*)\"$")
    public void binaryInput(String binaryInput) {
        this.binaryInput = binaryInput;
    }

    @When("^converted to octal$")
    public void convertTo() {
        result = main.convertBinary(binaryInput, "octal");
    }

    @Then("^the result should be \\\"([^\\\"]*)\\\"$")
    public void theResultShouldBe(String expectedOutput) {
        assertEquals(expectedOutput, result);
    }

}


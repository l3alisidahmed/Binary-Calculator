package org.example;

import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = {"src/test/resources"}
)
public class CucumberTestRunner {
}
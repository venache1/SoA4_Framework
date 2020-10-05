package com.endava.soa4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"com/endava/soa4/stepdefs"},
        tags = {"@Claudia or @Anatolie or @Irina or @Stefan or @Artiom", "@run"})
public class RunCucumberTest {
}

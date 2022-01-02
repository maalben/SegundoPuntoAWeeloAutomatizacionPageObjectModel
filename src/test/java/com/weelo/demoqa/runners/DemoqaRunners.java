package com.weelo.demoqa.runners;

import com.weelo.demoqa.utilities.BeforeSuite;
import com.weelo.demoqa.utilities.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features = "src/test/resources/features/demoqa.feature",
        glue = "com.weelo.demoqa.definitions",
        snippets = SnippetType.CAMELCASE
)

public class DemoqaRunners {
    @BeforeSuite
    public static void test() throws IOException, InvalidFormatException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/demoqa.feature");
    }
}

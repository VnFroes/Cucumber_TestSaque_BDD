import org.junit.runner.RunWith;

import io.cucumber.core.snippets.SnippetType;
import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"pretty"},
	monochrome = true,
	snippets = io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE,
	dryRun = false
		)
public class Runner {
	

}

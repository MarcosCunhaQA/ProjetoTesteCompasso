package br.com.compasso.test.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import br.com.compasso.test.core.Report;
import br.com.compasso.test.pages.BasePage;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/resources/features/",
		glue = {"br.com.compasso.test.steps"},
		tags = "@Run",
		plugin = {"pretty", "html:target/report-html/", "json:target:report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/report-html/extent-report.html"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class Runner extends BasePage {
	
	@BeforeClass
	public static void before() {
		Report.getReport().limparPastas();
	}
	
	@AfterClass
	public static void writeExtentReport() {
		Report.getReport().zipFolder();
	}
}
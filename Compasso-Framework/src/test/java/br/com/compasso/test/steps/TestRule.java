package br.com.compasso.test.steps;

import static br.com.compasso.test.core.DriverFactory.getDriver;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;

import br.com.compasso.test.core.DbManager;
import br.com.compasso.test.core.Report;
import br.com.compasso.test.pages.LoginPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	LoginPage loginPage = new LoginPage();
	private Report report = new Report();
	private DbManager db = DbManager.getDbManagerSql();
	private TakesScreenshot ss;
	private Scenario scenario;
	
	public TestRule() {	
	}
	
	@After
	public void fecharBrowser(Scenario cenario) throws IOException {
		report.getScreenShot(cenario);
		loginPage.fecharBrowser(); 	
		//Quando configurar a string de conexão com o banco de dados SqlServer, descomentar o metodo abaixo 
		//caso queira gerar um backup do banco ao final de cada teste.
		//db.backupDbSql();
	}

	@Before
	public void iniciliazarCenario(Scenario scenario) {
		this.scenario = scenario;
		this.ss = (TakesScreenshot) getDriver();
		
		//@@@@@ Importante:
		//Quando configurar a string de conexão com o banco de dados SqlServer, descomentar o metodo abaixo 
		//para restaurar a base no inicio de cada teste.
		//db.restoreDbSql();
	}

	public Scenario getScenario() {
		return this.scenario;
	}
	
}

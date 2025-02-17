package br.com.compasso.test.steps;

import java.io.IOException;

import br.com.compasso.test.core.Properties;
import br.com.compasso.test.core.Report;
import br.com.compasso.test.pages.FolhaPage;
import br.com.compasso.test.pages.GloboPage;
import br.com.compasso.test.pages.GloboesportePage;
import br.com.compasso.test.pages.HomePage;
import br.com.compasso.test.pages.LoginPage;
import br.com.compasso.test.pages.UolPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {

	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private UolPage uolPage = new UolPage();
	private GloboPage globoPage = new GloboPage();
	private GloboesportePage globoesportePage = new GloboesportePage();
	private FolhaPage folhaPage = new FolhaPage();	
	private Report report = new Report();
	private TestRule tr = new TestRule();
	private String usuario;
	private String senha;

	public StepDefinition() {
		this.usuario = Properties.USER_LOGIN;
		this.senha = Properties.PASSWORD_LOGIN;
	}
	
	@Given("que acesso o site do google")
	public void acessoOpen() throws IOException {
		loginPage.acessarPaginaPrincipal();
		report.writeReport("Teste google acesso write...");
		report.getScreenShot("testeAcessoGoogle");
	}

	@When("pesquiso pelo site {string}")
	public void pesquisoSiteLancenet(String site) {
		homePage.pesquisarSiteLancenet(site);
		report.writeReport("Teste pesquiso pelo site...");
		report.getScreenShot("testePesquisaSite");
	}

	@Then("acesso o primeiro site retornado do globo")
	public void acessoPrimeiroSiteRetornadoGlobo() {
		homePage.acessarPrimeiroSiteRetornadoGlobo();
		report.writeReport("Teste acesso o primeiro site retornado...");
		report.getScreenShot("testeAcessoSite");
	}

	@When("acesso o primeiro site retornado do UOL")
	public void acessoPrimeiroSiteRetornadoUOL() {
		 homePage.acessarPrimeiroSiteRetornadoUOL();
		 report.writeReport("Teste acesso Uol...");
		 report.getScreenShot("testeAcessoUol");
	}

	@When("clico no link para o GloboEsporte")
	public void clicoLinkGloboEsporte() {
		 globoPage.clicarLinkGloboesporte();
		 report.writeReport("Teste acesso GloboEsporte...");
		 report.getScreenShot("testeAcessoGloboEsporte");
	}

	@When("clico no link para a Folha de São Paulo")
	public void clicoLinkFolha() {
		 uolPage.clicarLinkFolha();
		 report.writeReport("Teste acesso Folha...");
		 report.getScreenShot("testeAcessoFolha");
	}

	@Then("valido o menu do site Globo Esporte")
	public void validoConteudoTituloGloboEsporte() {
		 globoesportePage.validarConteudoTitulo();
		 report.writeReport("Teste valido menu GloboEsporte...");
	}

	@Then("valido a existência do link Cotidiano")
	public void validoLinkCotidiano() {
		 folhaPage.validarLinkCotidiano();
		 report.writeReport("Teste link Cotidiano...");
	}
}

package br.com.compasso.test.pages;

public class GloboesportePage extends BasePage {
	
	private String XPATH_MENU_GLOBOESPORTE = "//header[@id='header-produto']//div[2]//span[contains(text(),'MENU')]";

	
	public GloboesportePage() {
		
	}
	
	public void validarConteudoTitulo() {
		getDSL().validarConteudo(XPATH_MENU_GLOBOESPORTE, "MENU");
	}
	
 
}

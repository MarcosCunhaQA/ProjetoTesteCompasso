package br.com.compasso.test.pages;

public class FolhaPage extends BasePage {
	
	private String XPATH_LINK_COTIDIANO = "//ul[@class='c-site-nav__list']//li[6]//a";

	
	public FolhaPage() {
		
	}
	
	public void validarLinkCotidiano() {
		esperarPaginaCarregar();
		getDSL().validarConteudo(XPATH_LINK_COTIDIANO, "cotidiano");
	}
	
 
}

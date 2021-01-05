package br.com.compasso.test.pages;

import java.util.Objects;

public class UolPage extends BasePage {
	
	private String XPATH_LINK_FOLHA = "//a//span[contains(text(),'Folha')]";
	
	public UolPage() {
		
	}
	
	
	public void clicarLinkFolha() {
		getDSL().clicar(XPATH_LINK_FOLHA);
	}
	
 
}

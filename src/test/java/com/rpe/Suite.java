package com.rpe;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.CadastroCliente;
import pages.Login;
import pages.Menu;
import pages.Transacao;



public class Suite {
	private WebDriver driver;
	private Login login;
	private Menu menu;
	private CadastroCliente cadastroCliente;
	private Transacao transacao;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver");
		driver = new FirefoxDriver();
		login = new Login(driver);
		menu = new Menu(driver);
		cadastroCliente = new CadastroCliente(driver);
		transacao = new Transacao(driver);

	}

	@Test
	public void login()   {
		login.efetuarLogin("admin","admin");
		login.esperarMensagemBemVindo();
	}


	@Test
	public void cadastroCliente() throws InterruptedException {
		login.efetuarLogin("admin","admin");
		menu.esperaMenuQA();
		menu.mouseHoverMenuQA();
		cadastroCliente.mouseHoverMenuClientes();
		cadastroCliente.clickMenuIncluirCliente();
		cadastroCliente.preencherNome("Fernando" );
		cadastroCliente.preencherCPF("18671343065");
		cadastroCliente.verificarStatus();
		cadastroCliente.preencherSaldoDisponivel("10000");
		cadastroCliente.clicarBotaoSalvar();
		cadastroCliente.validarMensagemSucesso();
		

	}

	@Test
	public void transacao() throws InterruptedException {
		login.efetuarLogin("admin","admin");
		menu.esperaMenuQA();
		menu.mouseHoverMenuQA();
		transacao.mouseHoverMenuTransacoes();
		transacao.clicarMenuIncluirTransacoes();
		transacao.selecionaCliente("cliente 102");
		transacao.preencheValorTransicao("10");
		transacao.salvarTransacao();
		transacao.validarMensagemSucesso();
	}


	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}


package pages;


import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroCliente {
	private WebDriver driver;

	private By menuClientes = By.xpath("//a[@title='Clientes']");
	private By menuIncluirClientes = By.xpath("//a[contains(@title,'Incluir')]");
	private By campoNome = By.id("nome");
	private By campocpf = By.id("cpf");
	private By ativo = By.id("status");
	private By campoSaldoDisponivel = By.id("saldoCliente");	
	private By botaoSalvar = By.id("botaoSalvar");	
	private By mensagemClienteSalvo = By.xpath("//strong[contains(.,'Cliente salvo com sucesso')]");	

	public CadastroCliente(WebDriver driver) {
		this.driver = driver;
	}



	public void mouseHoverMenuClientes() {
		Actions actions= new Actions(driver);
		actions.moveToElement(driver.findElement(menuClientes)).perform();
	}

	public void clickMenuIncluirCliente() {
		driver.findElement(menuIncluirClientes).click();
	}

	public void preencherNome(String nome) {
		driver.findElement(campoNome).sendKeys(nome);
	}

	public void preencherCPF(String cpf) {
		driver.findElement(campocpf).sendKeys(cpf);
	}
	public void verificarStatus() {
		WebElement status = driver.findElement(ativo);
		WebElement selectedOption = status.findElement(By.xpath("//option[@value='true'][contains(.,'Ativo')]"));
		assertEquals( selectedOption.getText(), "Ativo");
	}

	public void preencherSaldoDisponivel(String saldo) {
		driver.findElement(campoSaldoDisponivel).sendKeys(saldo);

	}

	public void clicarBotaoSalvar() {
		driver.findElement(botaoSalvar).click();
	}
	
	public void validarMensagemSucesso() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(500));
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemClienteSalvo));
		assertEquals( messageElement.getText(), "Cliente salvo com sucesso");

	}
}

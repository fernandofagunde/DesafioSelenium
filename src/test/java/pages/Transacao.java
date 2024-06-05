package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Transacao {
	private WebDriver driver;

	private By menuTransacoes = By.xpath("//a[contains(@title,'Transações')]");
	private By menuIncluirTransacoes = By.xpath("//a[@href='/desafioqa/incluirVenda'][contains(.,'Incluir')]");
	private By selectCliente = By.id("cliente");
	private By campoValorTransacao = By.id("valorTransacao");
	private By botaoSalvar = By.id("botaoSalvar");
	private By mensagemVendaSalva = By.xpath("//strong[contains(.,'Venda realizada com sucesso')]");	

	public Transacao(WebDriver driver) {
		this.driver = driver;
	}

	public void mouseHoverMenuTransacoes() {

		WebElement botaoClientes = driver.findElement(menuTransacoes);
		Actions actions = new Actions(driver);
		actions.moveToElement(botaoClientes).perform();
	}
	public void clicarMenuIncluirTransacoes() {

		driver.findElement(menuIncluirTransacoes).click();
	}

	public void selecionaCliente(String cliente) {

		WebElement selectElement = driver.findElement(selectCliente);
		Select select = new Select(selectElement);

		select.selectByVisibleText(cliente);
	}
	public void preencheValorTransicao(String valor) {
		driver.findElement(campoValorTransacao).sendKeys(valor);
	}

	public void salvarTransacao() {

		driver.findElement(botaoSalvar).click();
	}

	public void validarMensagemSucesso() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(500));
		WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemVendaSalva));
		assertEquals( messageElement.getText(), "Venda realizada com sucesso");

	}
}

package pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	private WebDriver driver;

	private By campoLogin = By.name("username");
	private By campoPassword = By.name("password");
	private By botaoSignin = By.xpath("//button[contains(text(),'Sign in')]");
	private By mensagemBemVindo = By.tagName("h1");

	public Login(WebDriver driver) {
		this.driver = driver;
	}


	public void efetuarLogin(String login, String password) {
		driver.get("http://54.166.20.145:9080/desafioqa/");
		driver.findElement(campoLogin).sendKeys(login);
		driver.findElement(campoPassword).sendKeys(password);
		driver.findElement(botaoSignin).click();



	}
	public void esperarMensagemBemVindo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(500));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemBemVindo));
		assertEquals( element.getText(), "Bem vindo ao Desafio");

	}

}

package pages;



import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Menu {
    private WebDriver driver;

    private By menuQA = By.xpath("//span[contains(text(),'QA')]");

    public Menu(WebDriver driver) {
        this.driver = driver;
    }

    public void mouseHoverMenuQA() {
		Actions actions = new Actions(driver);
		actions = new Actions(driver); actions.moveToElement(driver.findElement(menuQA)).perform();
    }
    
    public void esperaMenuQA() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10),Duration.ofMillis(500));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(menuQA));
		assertEquals(element.getText(),"QA");
    }

   

}


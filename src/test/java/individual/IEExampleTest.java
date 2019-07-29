package individual;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IEExampleTest {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {

        WebDriverManager.iedriver().setup();

        driver = new InternetExplorerDriver();

        driver.get("http://devexpress.github.io/testcafe/example");

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void seleniumBasicTest() {

        WebElement element = driver.findElement(By.id("developer-name"));
        element.clear();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', arguments[1])", element, "Test Name");
        element.sendKeys(Keys.ENTER);
    }
}


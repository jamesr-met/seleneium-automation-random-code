package aws;

import actions.CheckVisible;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium_AWS_Example {

    private WebDriver driver;

    private final String BASE_URL = "http://devexpress.github.io/testcafe/example";

    @BeforeTest
    public void setUp() {

        WebDriverManager.chromedriver().targetPath("/tmp").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"
                ,"--disable-extensions"
                ,"--disable-gpu"
                ,"--disable-dev-shm-usage"
                ,"--no-sandbox"
                ,"--headless");

        driver = new ChromeDriver(options);

        driver.get(BASE_URL);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void seleniumBasicTest() {

        String yourName = "Test Name";

        WebElement element = driver.findElement(By.id("developer-name"));
        element.clear();
        element.sendKeys(yourName);
        element.sendKeys(Keys.ENTER);

        CheckVisible checkVisible = new CheckVisible(20);

        String thankyouMessage = checkVisible.checkVisible(driver, By.id("article-header")).getText();
        if(!thankyouMessage.contains(yourName)){
            Assert.fail("Message " + thankyouMessage +" does not contain " + yourName);
        }

        driver.navigate().to(BASE_URL);
    }
}

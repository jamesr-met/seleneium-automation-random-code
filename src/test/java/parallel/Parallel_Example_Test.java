package parallel;

import actions.CheckVisible;
import org.openqa.selenium.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import setup.SelectLocalBrowser;


// To run the parallel tests click on the related xml file in the resources/launchers folder

public class Parallel_Example_Test {

    private final String BASE_URL = "http://devexpress.github.io/testcafe/example";

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        SelectLocalBrowser sb = new SelectLocalBrowser();
        driver = sb.selectBrowser(browser);

        driver.get(BASE_URL);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void seleniumBasicTest() {

        String yourName = "Test Name";

        WebElement element = driver.findElement(By.id("developer-name"));

        element.clear();
        if(driver.getClass() == InternetExplorerDriver.class){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('value', arguments[1])", element, yourName);
        }
        else{
            element.sendKeys(yourName);
        }

        element.sendKeys(Keys.ENTER);

        CheckVisible checkVisible = new CheckVisible(20);

        String thankyouMessage = checkVisible.checkVisible(driver, By.id("article-header")).getText();
        if(!thankyouMessage.contains(yourName)){
            Assert.fail("Message " + thankyouMessage +" does not contain " + yourName);
        }

        driver.navigate().to(BASE_URL);
    }
}

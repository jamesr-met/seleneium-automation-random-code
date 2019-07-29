package parallel;

import actions.CheckVisible;
import setup.ProxySetup;
import setup.SelectBrowserStackBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;

// To run the parallel tests click on the related xml file in the resources/launchers folder

public class BrowserstackSampleTest {

    private final String BASE_URL = "http://devexpress.github.io/testcafe/example";

    private RemoteWebDriver driver;


    @BeforeClass
    @Parameters({"browser", "version"})
    public void setUp(String browser, String version) throws MalformedURLException {

        if(browser == null || version == null){
            browser = "chrome";
            version = "65.0";
        }
        new ProxySetup();

        SelectBrowserStackBrowser sb = new SelectBrowserStackBrowser();
        driver = sb.SelectBrowser(browser, version);

        driver.manage().window().maximize();
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

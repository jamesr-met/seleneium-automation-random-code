package cloud;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.ProxySetup;

import java.net.MalformedURLException;
import java.net.URL;

public class SaucelabsSampleTest {

    private RemoteWebDriver driver;

    public static final String SAUCELABS_ACCESS_KEY ="2f9dddff-19b3-4c2f-8baa-a449b1ea5fcc";
    public static final String SAUCELABS_USERNAME ="14robertsjm";
    public static final String URL = "http://" + SAUCELABS_USERNAME + ":" + SAUCELABS_ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

    @BeforeTest
    public void setUp() throws MalformedURLException {

        new ProxySetup();

        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 8.1");
        caps.setCapability("version", "74.0");

        URL url = new URL(URL);
        driver = new RemoteWebDriver(url, caps);

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
        element.sendKeys("Test Name");
        driver. findElement(By.id("populate")).click();

    }
}


package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SelectLocalBrowser {
    private RemoteWebDriver driver;
    private String driverDirectory = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\";

    public RemoteWebDriver selectBrowser(String browser){

        switch(browser){
            case "firefox":
                selectFirefox();
                break;
            case "ie":
                selectIE();
                break;
            default:
                selectChrome();
        }
        this.driver.manage().window().maximize();

        return driver;
    }

    private void selectChrome(){

        WebDriverManager.chromedriver().version("74.0").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"
                ,"--disable-extensions"
                ,"--disable-gpu"
                ,"--disable-dev-shm-usage"
                ,"--no-sandbox"
//                ,"--headless"
        );

        this.driver = new ChromeDriver(options);
    }

    private void selectFirefox(){

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-infobars"
//                ,"--headless"
        );

        this.driver = new FirefoxDriver(options);;
    }

    private void selectIE(){
        WebDriverManager.iedriver().setup();

        this.driver = new InternetExplorerDriver();
    }

}

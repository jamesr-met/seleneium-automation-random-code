package setup;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SelectBrowserStackBrowser {
    private static final String USERNAME = "jamesroberts19";
    private static final String AUTOMATE_KEY = "siHfzRmmrVJhPd1vS9yn";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private RemoteWebDriver driver;

    public RemoteWebDriver SelectBrowser(String browser, String version) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", browser);
        caps.setCapability("browser_version", version);
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");

        driver = new RemoteWebDriver(new URL(URL), caps);

        return driver;

    }
}


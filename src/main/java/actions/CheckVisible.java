package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class CheckVisible {

    private long waitInSeconds;

    public CheckVisible(int waitInSeconds){
        this.waitInSeconds = waitInSeconds * 1000;
    }

    public WebElement checkVisible(WebDriver driver, By locator) {
        WebElement element = null;

        Date date = new Date();
        long endTime = date.getTime() + waitInSeconds;
        while (endTime >= date.getTime()){
            try {
                return element = driver.findElement(locator);
            } catch (NoSuchElementException e) {

            }
        }

        return element;
    }


}

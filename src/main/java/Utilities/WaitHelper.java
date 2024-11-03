package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
public static WebDriver ldriver;
    public WaitHelper(WebDriver driver) {
        ldriver = driver;
    }

    public void waitforElement(WebElement element, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElements(List<WebElement> elements, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(timeOutInSeconds));

        // Wait for all elements in the list to be visible
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }

    }
    public void waitele(int num){
        try{
            Thread.sleep(num);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void waitForOverlayToDisappear(List<WebElement> elements, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }
    public void waitforElementclick(WebElement element){
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
         WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(element));
        ele.click();

    }
}

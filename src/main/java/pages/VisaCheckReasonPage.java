package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class VisaCheckReasonPage {
    private final WebDriver driver;

    public VisaCheckReasonPage(WebDriver driver){
        this.driver = driver;
    }

    private By radioLabels = By.cssSelector(".govuk-radios__label");
    private By continueButton = By.cssSelector("form[data-type='radio_question'] button[type='submit']");

    public void selectReason(String reasonText) {
        String normalized = reasonText.toLowerCase().trim();

        switch (normalized) {
            case "study":
                driver.findElement(By.id("response-2")).click();
                break;
            case "tourism or visiting family and friends":
                driver.findElement(By.id("response-0")).click();
                break;
            case "work, academic visit or business":
                driver.findElement(By.id("response-1")).click();
                break;
            case "transit (on your way to somewhere else)":
                driver.findElement(By.id("response-3")).click();
                break;
            case "join partner or family for a long stay":
                driver.findElement(By.id("response-4")).click();
                break;
            case "get married or enter into a civil partnership":
                driver.findElement(By.id("response-5")).click();
                break;
            case "have medical treatment":
                driver.findElement(By.id("response-7")).click();
                break;
        }
    }

    public VisaCheckResultPage clickContinue() {
        try {
            Thread.sleep(3000);  // Pause for 3 seconds - gives you time to inspect
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(continueButton).click();
        try {
            Thread.sleep(3000);  // Pause for 3 seconds - gives you time to inspect
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new VisaCheckResultPage(driver);
    }
}

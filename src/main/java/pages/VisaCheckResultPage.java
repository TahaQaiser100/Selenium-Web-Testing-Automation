package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisaCheckResultPage {
    private final WebDriver driver;

    public VisaCheckResultPage(WebDriver driver){
        this.driver = driver;
    }

    private final By resultHeader = By.cssSelector(".govuk-heading-xl");
    private final By resultVerdictHeader = By.cssSelector(".govuk-header-m");

    public String getResultHeaderText(){
        return driver.findElement(resultHeader).getText();
    }

    public String getResultVerdictHeader(){
        return driver.findElement(resultVerdictHeader).getText();
    }


}

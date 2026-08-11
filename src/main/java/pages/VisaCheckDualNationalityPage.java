package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisaCheckDualNationalityPage {
    private final WebDriver driver;

    public VisaCheckDualNationalityPage(WebDriver driver){
        this.driver = driver;
    }

    private final By continueButton = By.cssSelector("form[data-type='radio_question'] button[type='submit']");
    private final By yesTickBox = By.id("response-0");
    private final By noTickBox = By.id("response-1");
    private final By dontKnowTickBox = By.id("response-2");

    public void selectDualCitizenShipOption(String option){

        switch(option){
            case "yes":
                driver.findElement(yesTickBox).click();
                break;
            case "no":
                driver.findElement(noTickBox).click();
                break;
            case "I don't know":
                driver.findElement(dontKnowTickBox).click();
                break;
        }
    }

    public VisaCheckReasonPage clickContinue(){
        driver.findElement(continueButton).click();
        return new VisaCheckReasonPage(driver);
    }

}

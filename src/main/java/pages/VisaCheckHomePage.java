package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VisaCheckHomePage {
    private final WebDriver driver;
    private final String BASE_URL = "https://www.gov.uk/check-uk-visa";

    public VisaCheckHomePage(WebDriver driver){
        this.driver = driver;
    }

    private final By startButton = By.cssSelector("a.govuk-button--start");


    public void navigateToHomePage(){
        driver.get(BASE_URL);
    }

    public VisaCheckNationalityPage clickStartButton(){
        driver.findElement(startButton).click();
        return new VisaCheckNationalityPage(driver);
    }

}

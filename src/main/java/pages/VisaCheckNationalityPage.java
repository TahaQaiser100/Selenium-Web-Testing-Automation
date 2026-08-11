package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class VisaCheckNationalityPage {
    private final WebDriver driver;

    public VisaCheckNationalityPage(WebDriver driver){
        this.driver = driver;
    }


    private final By continueButton = By.cssSelector("form[data-type='country_select_question'] button[type='submit']");
    private final By countrySelector = By.id("response");

    public void selectNationality(String nationality){
        Select dropDown = new Select(driver.findElement(countrySelector));
        dropDown.selectByVisibleText(nationality);
    }

    public VisaCheckDualNationalityPage clickContinue(){
        driver.findElement(continueButton).click();
        return new VisaCheckDualNationalityPage(driver);
    }
}

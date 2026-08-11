package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;
import utilities.DriverFactory;
import org.junit.jupiter.api.Assertions;


public class VisaRequirementsStepDef {

    private WebDriver driver;
    private VisaCheckHomePage visaCheckHomePage;
    private VisaCheckNationalityPage visaCheckNationalityPage;
    private VisaCheckDualNationalityPage visaCheckDualNationalityPage;
    private VisaCheckResultPage visaCheckResultPage;
    private VisaCheckReasonPage visaCheckReasonPage;


    @Given("I navigate to the GOV.UK Check if you need a visa website")
    public void iNavigateToTheGOVUKCheckIfYouNeedAVisaWebsite() {
        driver = DriverFactory.getDriver();
        visaCheckHomePage = new VisaCheckHomePage(driver);
        visaCheckHomePage.navigateToHomePage();
    }

    @And("I start the visa eligibility assessment")
    public void iStartTheVisaEligibilityAssessment() {
        visaCheckNationalityPage = visaCheckHomePage.clickStartButton();
    }

    @When("I select passport nationality {string}")
    public void iSelectPassportNationality(String nationality) {
        visaCheckNationalityPage.selectNationality(nationality);
        visaCheckDualNationalityPage = visaCheckNationalityPage.clickContinue();
    }

    @And("I select answer dual nationality as {string}")
    public void iSelectAnswerDualNationalityAs(String option) {
        visaCheckDualNationalityPage.selectDualCitizenShipOption(option);
        visaCheckReasonPage = visaCheckDualNationalityPage.clickContinue();
    }


    @And("I select travel reason {string}")
    public void iSelectTravelReason(String reason) {
        visaCheckReasonPage.selectReason(reason);
        visaCheckResultPage = visaCheckReasonPage.clickContinue();
    }

    @Then("I should be informed whether I need a visa")
    public void iShouldBeInformedWhetherINeedAVisa() {
        String mainHeader = visaCheckResultPage.getResultHeaderText();

        Assertions.assertTrue(
                mainHeader.contains("visa"), "Unexpected Error"
        );
    }

    @When("I do not select a nationality")
    public void iDoNotSelectANationality() {
    }

    @And("I click continue")
    public void iClickContinue() {
    }

    @Then("I should see an error show up")
    public void iShouldSeeAnErrorShowUp() {
    }



}

package transfermate.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import transfermate.automation.steps.TranferMatePageSteps;

public class SignUpPageStepDefinitions {

    @Steps
    TranferMatePageSteps tranferMatePageSteps;

    @Given("^TransferMate Sign-Up page opened successfully$")
    public void researchingThings() {
        tranferMatePageSteps.openPage();
    }

    @And("^the user clicks on \"([^\"]*)\" cookies button$")
    public void theUserClicksIAcceptCookiesButton(String button) {
        tranferMatePageSteps.userClicksButton(button);
    }

    @And("^register form is available$")
    public void registerFormIsAvailable() {
        tranferMatePageSteps.registerFormIsAvailable();
    }

    @When("^user chooses \"([^\"]*)\" option from the list$")
    public void userChoosesOptionFromTheList(String option) {
        tranferMatePageSteps.userChoosesOptionFromTheList(option);
    }

    @And("^the country \"([^\"]*)\" is selected from the country dropdown$")
    public void userChoosesOptionFromTheCountryDropdown(String country) {
        tranferMatePageSteps.userChoosesOptionFromTheCountryDropdown(country);
    }

    @And("^First Name field is filled in with \"([^\"]*)\"$")
    public void firstNameFieldIsFilledInWith(String firstname) {
        tranferMatePageSteps.firstNameFieldIsFilledInWith(firstname);
    }

    @And("^Last Name Field is filled in  with \"([^\"]*)\"$")
    public void lastNameFieldIsFilledInWith(String lastname) {
        tranferMatePageSteps.lastNameFieldIsFilledInWith(lastname);
    }

    @And("^email field is filled in with a mail address$")
    public void emailFieldIsFilledInWithAMailAddress() {
        tranferMatePageSteps.emailFieldIsFilledInWithAMailAddress();
    }

    @And("^Mobile phone country prefix for \"([^\"]*)\" is filled$")
    public void mobilePhoneCountryPrefixIsFilledInWith(String phoneprefix) {
        tranferMatePageSteps.mobilePhoneCountryPrefixIsFilledInWith(phoneprefix);
    }
    @And("^Mobile phone is filled in with \"([^\"]*)\" phone number$")
    public void mobilePhoneIsFilledInWith(String phoneNumber) {
        tranferMatePageSteps.mobilePhoneIsFilledInWith(phoneNumber);
    }

    @And("^the Terms and Privacy button is checked$")
    public void termsAndPrivacyButtonIsChecked() {
        tranferMatePageSteps.termsAndPrivacyButtonIsChecked();
    }

    @And("^the correct result is entered in the register captcha$")
    public void theCorrectResultIsEnteredInCaptcha() {
        tranferMatePageSteps.theCorrectResultIsEnteredInCaptcha();
    }

    @And("^user clicks on Open my free account$")
    public void userClicksOnOpenMyFreeAccount() {
        tranferMatePageSteps.userClicksOnOpenMyFreeAccount();
    }

    @And("^the user is redirected to the Check your mail page$")
    public void userIsRedirectedToTheCheckYourMailPage() {
        tranferMatePageSteps.userIsRedirectedToTheCheckYourMailPage();
    }

    @When("^the user opens his inbox and checks mail$")
    public void userOpensHisInbox() {
        tranferMatePageSteps.userOpensHisInbox();
    }

    @When("^a mail from transfermate is received$")
    public void mailFromFransfermateIsReceived() {
        tranferMatePageSteps.mailFromFransfermateIsReceived();
    }

    @And("^the user clicks on the Activate My Account button in the received mail$")
    public void userClicksActivateMyAccountInTheReceivedMail() {
        tranferMatePageSteps.userClicksActivateMyAccountInTheReceivedMail(); }

    @Then("^the user is redirected to the Account activation page$")
    public void userIsRedirectedToTheAccountActivationPage() {
        tranferMatePageSteps.userIsRedirectedToTheAccountActivationPage();
    }

    @When("^the user fills in the password field with \"([^\"]*)\"$")
    public void userFillsPasswordFieldWith(String accPassword) {
        tranferMatePageSteps.userFillsPasswordFieldWith(accPassword);
    }

    @When("^the user fills in the repeat password field with \"([^\"]*)\"$")
    public void userFillsPasswordRepeatFieldWith(String accPassword) {
        tranferMatePageSteps.userFillsPasswordRepeatFieldWith(accPassword);
    }

    @Then("^the Two-Step Verification pop-up appears$")
    public void theTwoStepVerificationPopupAppears() {
        tranferMatePageSteps.theTwoStepVerificationPopupAppears();
    }

}

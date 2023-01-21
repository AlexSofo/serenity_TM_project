package transfermate.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import transfermate.automation.pages.TransferMatePage;

public class TranferMatePageSteps extends ScenarioSteps {

    TransferMatePage transferMatePage;

    @Step
    public void openPage() {
        transferMatePage.open();
    }
    @Step
    public void registerFormIsAvailable() {
        Assert.assertTrue(transferMatePage.isRegisterFormIsAvailable());
    }
    @Step
    public void userChoosesOptionFromTheList(String option) {
        transferMatePage.selectOptionFromTheList(option);
    }
    @Step
    public void userClicksButton(String button) {
        transferMatePage.userClicksButton(button);
    }
    @Step
    public void userChoosesOptionFromTheCountryDropdown(String country) {
        transferMatePage.selectCountryFromDropdown(country);
    }
    @Step
    public void firstNameFieldIsFilledInWith(String firstname) {
        transferMatePage.fillFirstNameWith(firstname);
    }
    @Step
    public void lastNameFieldIsFilledInWith(String lastname) {
        transferMatePage.lastNameFieldIsFilledInWith(lastname);
    }
    @Step
    public void termsAndPrivacyButtonIsChecked() {
        transferMatePage.checkTermsAndPrivacyButton();
    }
    @Step
    public void mobilePhoneCountryPrefixIsFilledInWith(String phoneprefix) {
        transferMatePage.chooseCountryPrefix(phoneprefix);
    }
    @Step
    public void mobilePhoneIsFilledInWith(String phoneNumber) {
        transferMatePage.fillMobilePhoneFieldWith(phoneNumber);
    }
    @Step
    public void emailFieldIsFilledInWithAMailAddress() {
        transferMatePage.fillEmailInputField();
    }
    @Step
    public void theCorrectResultIsEnteredInCaptcha() {
        transferMatePage.enterResultInCaptcha();
    }
    @Step
    public void userClicksOnOpenMyFreeAccount() {
        transferMatePage.clickOnOpenMyFreeAccount();
    }
    @Step
    public void userIsRedirectedToTheCheckYourMailPage() {
        Assert.assertTrue(transferMatePage.isRedirectedToTheCheckYourMailPage());
    }
    @Step
    public void userOpensHisInbox() {
        transferMatePage.userOpensHisInbox();
    }
    @Step
    public void mailFromFransfermateIsReceived() {
        Assert.assertTrue(transferMatePage.isMailFromFransfermateReceived());
    }
    @Step
    public void userClicksActivateMyAccountInTheReceivedMail() {
        transferMatePage.userClicksActivateMyAccount();
    }
    @Step
    public void userIsRedirectedToTheAccountActivationPage() {
        Assert.assertTrue(transferMatePage.isUserRedirectedToTheAccountActivationPage());
    }
    @Step
    public void userFillsPasswordFieldWith(String accPassword) {
        transferMatePage.fillPasswordFieldWith(accPassword);
    }
    @Step
    public void userFillsPasswordRepeatFieldWith(String accPassword) {
        transferMatePage.userFillsPasswordRepeatFieldWith(accPassword);
    }
    @Step
    public void theTwoStepVerificationPopupAppears() {
        Assert.assertTrue(transferMatePage.theTwoStepVerificationPopupAppears());
    }
}

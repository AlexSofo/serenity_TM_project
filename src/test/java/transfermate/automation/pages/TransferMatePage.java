package transfermate.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TransferMatePage extends PageObject {

    private static final String REGISTER_FORM_ID = "register_form_table_frame";
    private static final String SIGN_UP_TITLE_XPATH = "//h1[contains(text(),'Sign up now')]";
    private static final String INDIVIDUAL_RADIO_BUTTON_ID = "register_account_type_individual_form_input";
    private static final String ACCEPT_COOKIES_ID = "cookies-read-more-link";
    private static final String REGISTER_COUNTRY_FORM_ID = "register_country_form_input";
    private static final String REGISTER_COUNTRY_FORM_OPTION_XPATH = "//*[@id=\"country\"] /*[text()='%s']";
    private static final String FIRST_NAME_INPUT_CSS = "#first_name";
    private static final String LAST_NAME_INPUT_CSS = "#last_name";
    private static final String TERMS_PRIVACY_BUTTON_ID = "register_terms_of_use_agree_input_cell";
    private static final String COUNTRY_PREFIX_DROPDOWN_CSS = "#__pin_mobile_number_international_dialing_code";
    private static final String COUNTRY_PREFIX_XPATH = "//*[@name=\"__pin_mobile_number_international_dialing_code\"] /*[text()='%s']";
    private static final String PHONE_NUMBER_INPUT_CSS = "#__pin_mobile_number_mobile_phone";
    private static final String EMAIL_INPUT_ID = "email";
    private static final String CAPTCHA_INPUT_CSS = "#__calc_captcha_text";
    private static final String CAPTCHA_QUESTION_XPATH = "//*[@id=\"cal_captcha_f10_question\"]/span";
    private static final String OPEN_ACCOUNT_ID = "register_button_subscribe_form_input";

    private static final String MAIL_COPY_XPATH = "//*[@id=\"tm-body\"]/div[1]/div/div/div[2]/div[1]/form/div[2]/button";
    private static final String RECEIVED_MAIL_XPATH = "//div/div[4]/ul/li[2]/div[1]/a/span[@class='inboxSenderEmail inboxSenderEllipsis']";
    private static final String ACTIVATE_ACCOUNT_XPATH = "//a/span[text()='Activate My Account']";
    private static final String ACTIVATE_ACC_PSWD_CSS = "#password";
    private static final String ACTIVATE_ACC_PSWD_REPEAT_CSS = "#confirm_password";
    private static final String USER_PIN_CSS = "#user_pin";
    private static final String MAIL_REFRESH_XPATH = "//*[@id=\"click-to-refresh\"]/span";


    public TransferMatePage(WebDriver driver) {super(driver);}

    public boolean isRegisterFormIsAvailable() {
        waitforpagetoLoad();
        return element(By.id(REGISTER_FORM_ID)).isVisible();
    }

    @WhenPageOpens
    private void waitforpagetoLoad() {
        element(By.xpath(SIGN_UP_TITLE_XPATH)).waitUntilVisible();
    }

    public void selectOptionFromTheList(String option) {

        switch(option.toUpperCase()){
            case "INDIVIDUAL" :
                element(By.id(INDIVIDUAL_RADIO_BUTTON_ID)).waitUntilClickable().click(); break;
        }

    }

    public void userClicksButton(String button) {

        switch(button.toUpperCase()) {
            case "I ACCEPT":
                element(By.id(ACCEPT_COOKIES_ID)).waitUntilClickable().click(); break;
        }
    }

    public void selectCountryFromDropdown(String country) {
        element(By.id(REGISTER_COUNTRY_FORM_ID)).waitUntilClickable().click();
        WebElement chosenCountry= element(By.xpath(String.format(REGISTER_COUNTRY_FORM_OPTION_XPATH,country)));
        scrollToElement(getDriver(),chosenCountry);
        waitFor(chosenCountry).waitUntilClickable().click();
    }

    //helper util method
    public static void scrollToElement(WebDriver webdriver, WebElement element){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webdriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",element);
    }

    public void fillFirstNameWith(String firstname) {
        element(By.cssSelector(FIRST_NAME_INPUT_CSS)).sendKeys(firstname);
    }

    public void lastNameFieldIsFilledInWith(String lastname) {
        element(By.cssSelector(LAST_NAME_INPUT_CSS)).sendKeys(lastname);
    }

    public void checkTermsAndPrivacyButton() {
        //element(By.id(TERMS_PRIVACY_BUTTON_ID)).click();
        element(By.id(TERMS_PRIVACY_BUTTON_ID)).waitUntilClickable().click();
    }

    public void fillMobilePhoneFieldWith(String phoneNumber) {
        element(By.cssSelector(PHONE_NUMBER_INPUT_CSS)).sendKeys(phoneNumber);
    }

    public void chooseCountryPrefix(String phoneprefix) {
        waitFor(visibilityOf(getDriver().findElement(By.cssSelector(COUNTRY_PREFIX_DROPDOWN_CSS))));
        scrollToElement(getDriver(), element(By.cssSelector(COUNTRY_PREFIX_DROPDOWN_CSS)));
        element(By.cssSelector(COUNTRY_PREFIX_DROPDOWN_CSS)).waitUntilClickable().click();

        WebElement chosenCountry= element(By.xpath(String.format(COUNTRY_PREFIX_XPATH,phoneprefix)));
        scrollToElement(getDriver(),chosenCountry);
        waitFor(chosenCountry).waitUntilClickable().click();
    }

    //helper method to switch back page
    public void getEmailAddres(){
         waitABit(5000);
         element(By.xpath(MAIL_COPY_XPATH)).waitUntilClickable().click();
         waitABit(1000);
    }
    //paste email to input field
    public void enterMailInField(By selector, String text){
        element(selector).click();
        element(selector).sendKeys(text);
    }

    public static String getClipboard(){
        String result = "";
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable content = clipboard.getContents(null);
        boolean hasStringText = (content != null) && content.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasStringText) {
            try {
                result = (String) content.getTransferData(DataFlavor.stringFlavor);
            }
            catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public void fillEmailInputField() {
        String transferWindow = getDriver().getWindowHandle();
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().navigate().to("https://temp-mail.org/en");
        //getDriver().switchTo().alert().accept();
        getEmailAddres();
        getDriver().switchTo().window(transferWindow);
        enterMailInField(By.id(EMAIL_INPUT_ID), getClipboard());
    }

    //helper method to get list of elements
    public static List<WebElement> getElementsByXpath(String xpath){
        return ThucydidesWebDriverSupport.getDriver().findElements(By.xpath(xpath))
                .stream()
                .collect(Collectors.toList());
    }

    public void enterResultInCaptcha() {
        String mathQuestion = "";
        for (WebElement element : getElementsByXpath(CAPTCHA_QUESTION_XPATH)){
            if (element.isDisplayed()) mathQuestion += element.getText();
        }
        int pos = mathQuestion.indexOf("+");
        if (pos == -1) {pos = mathQuestion.indexOf("-");}

        String firstOperand = mathQuestion.substring(0, pos);
        String secondOperand = mathQuestion.substring( pos+1 , (mathQuestion.length() - 1));

        int result = 0;
        String operator = String.valueOf(mathQuestion.charAt(pos));
        switch (operator) {
            case "+" : result = (Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand)); break;
            case "-" : result = (Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand));
        }
        element(By.cssSelector(CAPTCHA_INPUT_CSS)).sendKeys(String.valueOf(result));
        waitABit(5000);
    }

    public void clickOnOpenMyFreeAccount() {
        element(By.id(OPEN_ACCOUNT_ID)).waitUntilClickable().click();
    }

    public boolean isRedirectedToTheCheckYourMailPage() {
        return getDriver().getTitle().equals("Email and Mobile Number Verification");
    }

    public void userOpensHisInbox() {
        String transferWindow = getDriver().getWindowHandle();
        for (String windowHandle : getDriver().getWindowHandles()) {
            if(!transferWindow.contentEquals(windowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public boolean isMailFromFransfermateReceived() {
        waitABit(10000);
        return element(By.xpath(RECEIVED_MAIL_XPATH)).isVisible();
    }

    public void userClicksActivateMyAccount() {
        element(By.xpath(RECEIVED_MAIL_XPATH)).waitUntilClickable().click();
        element(By.xpath(ACTIVATE_ACCOUNT_XPATH)).waitUntilClickable().click();
    }

    public boolean isUserRedirectedToTheAccountActivationPage() {
        return element(By.cssSelector(ACTIVATE_ACC_PSWD_CSS)).isVisible();
    }

    public void fillPasswordFieldWith(String accPassword) {
        element(By.cssSelector(ACTIVATE_ACC_PSWD_CSS)).sendKeys(accPassword);
    }

    public void userFillsPasswordRepeatFieldWith(String accPassword) {
        element(By.cssSelector(ACTIVATE_ACC_PSWD_REPEAT_CSS)).sendKeys(accPassword);
    }

    public boolean theTwoStepVerificationPopupAppears() {
        return element(By.cssSelector(USER_PIN_CSS)).isVisible();
    }
}
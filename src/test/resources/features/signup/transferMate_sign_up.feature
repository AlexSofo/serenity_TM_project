Feature: Check sing-up page

  Background:

    Given TransferMate Sign-Up page opened successfully
    And the user clicks on "I accept" cookies button

  Scenario: User Sign-Up

    And register form is available
    When user chooses "Individual" option from the list
    And the country "United Kingdom" is selected from the country dropdown
    And First Name field is filled in with "aTest"
    And Last Name Field is filled in  with "Testing"
    And email field is filled in with a mail address
    And Mobile phone country prefix for "United Kingdom +44" is filled
    And Mobile phone is filled in with "111222333" phone number
    And the Terms and Privacy button is checked
    And the correct result is entered in the register captcha
    And user clicks on Open my free account
    Then the user is redirected to the Check your mail page

    #email verification and account activation part

    When the user opens his inbox and checks mail
    #Then a mail from transfermate is received
    #And the user clicks on the Activate My Account button in the received mail
    #Then the user is redirected to the Account activation page
    #When the user fills in the password field with "Test1234"
    #When the user fills in the repeat password field with "Test1234"
    #Then the Two-Step Verification pop-up appears





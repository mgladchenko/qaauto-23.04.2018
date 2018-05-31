package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinRequestPasswordResetPage;

public class LinkedinResetPasswordTest extends LinkedinBaseTest {

    @Test
    public void successfulPasswordResetTest() {
        String userEmail = "mykola.gladchenko@gmail.com";
        String newUserPassword = "P@ssword12345";

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage =
              linkedinLoginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "RequestPasswordResetPage is not loaded.");

        LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage =
                linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
        Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmitPage is not loaded.");

        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage =
                linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "SetNewPasswordPage is not loaded.");

        LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage =
                linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinSuccessfulPasswordResetPage.isPageLoaded(),
                "SuccessfulPasswordResetPage is not loaded.");

        LinkedinHomePage linkedinHomePage =
                linkedinSuccessfulPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "HomePage is not loaded.");










    }
}

package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;


    public LinkedinRequestPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        waitUntilElementIsClickable(resendLinkButton, 300);
        return resendLinkButton.isDisplayed();
    }

    public LinkedinSetNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "postoltest@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";
        String message = gMailService.waitMessage(
                messageSubject, messageTo, messageFrom, 300);

        String resetPasswordLink = StringUtils.substringBetween(
                message,
                "To change your LinkedIn password, click <a href=\"",
                "\" style").replace("&amp;","&");
        //System.out.println("Content: " + resetPasswordLink);

        webDriver.get(resetPasswordLink);

        return new LinkedinSetNewPasswordPage(webDriver);
    }
}

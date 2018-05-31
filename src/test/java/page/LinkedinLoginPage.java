package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage {

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return signInButton.isDisplayed();
    }

    public <T> T login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        if (getCurrentUrl().contains("/feed")) {
            return (T) new LinkedinHomePage(webDriver);
        }
        if (getCurrentUrl().contains("/login-submit")) {
            return (T) new LinkedinLoginSubmitPage(webDriver);
        }
        else {
            return (T) this;
        }
    }

    public LinkedinRequestPasswordResetPage clickOnForgotPasswordLink() {

        return new LinkedinRequestPasswordResetPage(webDriver);
    }
}
















package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSuccessfulPasswordResetPage extends LinkedinBasePage{

    @FindBy(xpath = "//button[text()='Go to homepage']")
    private WebElement goToHomepageButton;

    public LinkedinSuccessfulPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return goToHomepageButton.isDisplayed();
    }

    public LinkedinHomePage clickOnGoToHomeButton() {
        goToHomepageButton.click();
        return new LinkedinHomePage(webDriver);
    }
}

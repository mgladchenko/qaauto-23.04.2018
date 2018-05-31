package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends LinkedinBasePage {

    public LinkedinRequestPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return false;
    }
}

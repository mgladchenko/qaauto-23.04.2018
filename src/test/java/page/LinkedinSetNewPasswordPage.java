package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinSetNewPasswordPage extends LinkedinBasePage {

    public LinkedinSetNewPasswordPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}

import org.openqa.selenium.WebDriver;

public abstract class LinkedinBasePage {
    protected WebDriver webDriver;

    public LinkedinBasePage (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();



}

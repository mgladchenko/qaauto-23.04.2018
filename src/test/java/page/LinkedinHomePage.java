package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinHomePage extends LinkedinBasePage {

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private WebElement searchField;

    public LinkedinHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return profileNavItem.isDisplayed();
    }

    public LinkedinSearchResults search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new LinkedinSearchResults(webDriver);
    }
}

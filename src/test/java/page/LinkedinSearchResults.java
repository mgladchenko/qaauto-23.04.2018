package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinSearchResults extends LinkedinBasePage {

    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsCount;

    public LinkedinSearchResults(WebDriver webDriver) {
        super(webDriver);
        waitUntilElementIsClickable(searchResultsCount, 5);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded() {
        return searchResultsCount.isDisplayed();
    }
}

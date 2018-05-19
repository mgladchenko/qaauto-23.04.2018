import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

	@Test
	public void successfulLoginTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
				"LinkedIn: Log In or Sign Up",
				"Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");

        linkedinLoginPage.login("iteatest@i.ua", "1q2w3e_4r5t");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
		Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
				"https://www.linkedin.com/feed/",
				"Home page url is wrong.");
		Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
				"Home page Title is wrong.");
	}












	@Test
	public void negativeLoginTest() throws InterruptedException {
        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(actualLoginPageTitle,
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign In button is not Displayed");
        linkedinLoginPage.login("iteatest@i.ua", "1");

        sleep (3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page url is wrong");
        Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed.");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }





}

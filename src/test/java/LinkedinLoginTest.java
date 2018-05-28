import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.linkedin.com/");
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "iteatest@i.ua", "1q2w3e_4r5t" },
               // { "ITEATEST@I.UA", "1q2w3e_4r5t" }
        };
    }

	@Test(dataProvider="validDataProvider")
	public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
		Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
				"LinkedIn: Log In or Sign Up",
				"Login page Title is wrong");
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Login Page is not loaded.");
	}


	@Test
	public void negativeReturnedToLoginSubmitTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");
        linkedinLoginPage.login("iteatest@i.ua", "1");

        sleep (3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login-Submit page is not loaded.");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text is incorrect.");
    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }





}

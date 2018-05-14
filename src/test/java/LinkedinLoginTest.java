import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

	@Test
	public void successfulLoginTest() {
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://www.linkedin.com/");

		String actualLoginPageTitle = webDriver.getTitle();

		Assert.assertEquals(actualLoginPageTitle,
				"LinkedIn: Log In or Sign Up",
				"Login page Title is wrong");

		WebElement emailField = webDriver.findElement(By.id("login-email"));
		WebElement passwordField = webDriver.findElement(By.id("login-password"));
		WebElement signInButton = webDriver.findElement(By.id("login-submit"));

		Assert.assertTrue(signInButton.isDisplayed(),
				"Sign In button is not Displayed");

		emailField.sendKeys("iteatest@i.ua");
		passwordField.sendKeys("1q2w3e_4r5t");
		signInButton.click();

		Assert.assertEquals(webDriver.getCurrentUrl(),
				"https://www.linkedin.com/feed/",
				"Home page url is wrong.");

		String actualHomePageTitle = webDriver.getTitle();

		Assert.assertNotEquals(actualLoginPageTitle, actualHomePageTitle,
				"Page title did not change after Sign In");


		Assert.assertTrue(webDriver.getTitle().contains("LinkedIn"),
				"Home page url is wrong.");


	}


}

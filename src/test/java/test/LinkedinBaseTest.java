package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

public class LinkedinBaseTest {
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void before() {
        webDriver = new FirefoxDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(webDriver);

    }

    @AfterMethod
    public void after() {
        webDriver.close();
    }

}

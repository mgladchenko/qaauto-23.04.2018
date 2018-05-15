import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    private WebDriver webDriver;

    private WebElement emailField = webDriver.findElement(By.id("login-email"));
    private WebElement passwordField = webDriver.findElement(By.id("login-password"));
    private WebElement signInButton = webDriver.findElement(By.id("login-submit"));

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}

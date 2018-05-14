import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class BadCodeExample {

	public static void main(String args[]) throws InterruptedException {
		System.out.println("Hello World!!!");
		WebDriver webDriver = new FirefoxDriver();
		webDriver.get("https://www.google.com");

		WebElement searchField = webDriver.findElement(By.id("lst-ib"));
		searchField.sendKeys("Selenium");

		searchField.sendKeys(Keys.ENTER);

		sleep(3000);

		//		List<WebElement> searchResults = webDriver.findElements(
		//				By.xpath("//div[@class='srg']/div[@class='g']"));
		//
		//		System.out.println(searchResults.size());
		//
		//		for (WebElement searchResult : searchResults) {
		//			String searchResultText = searchResult.getText();
		//			if (searchResultText.contains("Selenium")) {
		//				System.out.println("SearchTerm found!!");
		//			}
		//			System.out.println(searchResultText);
		//		}

		for (int i = 1; i <= 10; i++) {
			WebElement searchResult = webDriver.findElement(
					By.xpath("//div[@class='srg']/div[" + i + "]"));
			String searchResultText = searchResult.getText();
			if (searchResultText.contains("Selenium")) {
				System.out.println("SearchTerm found!!");
			}
			System.out.println(searchResultText);
		}

		sleep(5000);
		webDriver.close();

	}

}

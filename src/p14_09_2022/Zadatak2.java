package p14_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {
//	Napisati program koji ucitava stranicu https://www.ebay.com/ i bira kategoriju “Crafts”

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath(("//*[contains(@name,'_sacat')]"))).click();
		Thread.sleep(1000);

		Select crafts = new Select(driver.findElement(By.xpath("//*[contains(@name,'_sacat')]")));
		Thread.sleep(1000);
		crafts.selectByVisibleText("Crafts");

		Thread.sleep(1000);
		driver.quit();
	}

}

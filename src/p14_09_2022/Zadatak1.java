package p14_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1. Zadatak
//		Napisati program koji prijavljivanju na stranicu http://cms.demo.katalon.com/my-account/, cekira Remember me checkbox.
//		(DOPUNA)
//		Na kraju programa proverite da li je element cekiran. Izguglajte kako mozemo da proverimo da li je element cekiran.

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://cms.demo.katalon.com/my-account/");

		driver.findElement(By.name("rememberme")).click();

		if (driver.findElement(By.name("rememberme")).isSelected()) {
			System.out.println("Checked!");
		} else {
			System.out.println("Unchecked!");

		}

		Thread.sleep(5000);
		driver.quit();

	}

}

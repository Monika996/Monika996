package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {

//2.Zadatak 
//Napisati program testira upload funkcionalnost: Koristan link https://www.guru99.com/upload-download-file-selenium-webdriver.html
//Ucitava stranicu https://crop-circle.imageonline.co/#circlecropresult
//Uploadujte sliku na sajt
//Kliknite na dugme Crop Circle

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		driver.findElement(By.id("inputImage"))
				.sendKeys("C:\\Users\\Admin\\Desktop\\photo-1530092285049-1c42085fd395.jpg");

		driver.findElement(By.id("photobutton")).click();

		Thread.sleep(5000);
		driver.quit();

	}

}

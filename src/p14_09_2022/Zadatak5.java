package p14_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
//	5.Zadatak
//	Ucitati stranicu https://demoqa.com/modal-dialogs
//	Kliknuti na dugme Large modal
//	Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://demoqa.com/modal-dialogs");
		driver.findElement(By.id("showLargeModal")).click();

		boolean elementExist = true;
		try {
			driver.findElement(By.id("example-modal-sizes-title-lg"));
		} catch (Exception e) {
			elementExist = false;
		}

		if (elementExist) {
			System.out.println("Modal je otvoren.");
		} else {
			System.out.println("Modal nije otvoren.");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}

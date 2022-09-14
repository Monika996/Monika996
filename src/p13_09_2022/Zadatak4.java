package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
//	4.Zadatak
//	Napisti proram koji :
//	Ucitava stranicu https://s.bootsnipp.com/iframe/oV91g
//	Hvatamo sve page-eve iz paginacije tabele
//	Zatim petljom prolazimo kroz paginaciju tako sto kliknemo na svaki broj
//	Izmedju iteracija napravite pauzu od 1s
//	Zatvorite pretrazivac

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://s.bootsnipp.com/iframe/oV91g\r\n");
		List<WebElement> pagination = driver.findElements(By.xpath(("//*[contains(@class,'page-link')]")));
		for (int i = 0; i < pagination.size(); i++) {
			pagination.get(i).click();
			Thread.sleep(1000);
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

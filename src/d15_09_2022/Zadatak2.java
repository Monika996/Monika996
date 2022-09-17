package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
//		2.Zadatak
//		Napisati program koji ucitava stranicu https://www.plus2net.com/jquery/msg-demo/dropdown3.php
//		Bira Country, State i City po vasoj zelji
//		Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//		I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//		Izabrerit Country, State i City tako da imate podatke da selektujete!

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.plus2net.com/jquery/msg-demo/dropdown3.php");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//*[(@id='country_code')]")).click();
		Thread.sleep(1000);
		
		Select country = new Select (driver.findElement(By.xpath("//*[(@id='country_code')]")));
		country.selectByVisibleText("AUSTRALIA");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[(@id='state_id')]")).click();
		Thread.sleep(1000);
		
		Select state = new Select(driver.findElement(By.xpath("//*[(@id='state_id')]")));
		state.selectByVisibleText("46:Victoria");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[(@id='city_id')]")).click();
		Thread.sleep(1000);
		
		Select city = new Select(driver.findElement(By.xpath("//*[(@id='city_id')]")));
		city.selectByVisibleText("Melbourne");
		Thread.sleep(1000);
		
		driver.quit();
	}

}

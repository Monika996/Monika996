package d15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {

		// 3.Zadatak (Za vezbanje)
		// Napisati program koji
		// Ucitava https://seeds.sproutsocial.com/components/loader-button/
		// Odskrola do Loader buttons are used to display a loading indicator inside of
		// a button. paragrafa. Koristan link
		// Klikce ne dugme
		// Ceka da dugme zavrsi sa loadingom
		// Ispisati poruku na ekranu
		// Zatvoriti pretrazivac
		// HINT: Koristite data-qa-button-isloading atribut elementa za cekanje
		// odredjenog stanja tog elementa

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement hoverable = driver.findElement(By.xpath("//*[contains(@class, 'dzjEcK')]"));
		new Actions(driver).moveToElement(hoverable).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class, 'dzjEcK')]")).click();

		boolean ucitavanjeElementa = true;

		try {
			driver.findElement(By.xpath("//*[contains(@class, 'dzjEcK')]"));
		} catch (Exception e) {
			ucitavanjeElementa = false;

		}
		if (ucitavanjeElementa) {
			System.out.println("Dugme se ucitalo.");
		} else {
			System.out.println("Dugme se nije ucitalo.");
		}

		Thread.sleep(1000);
		driver.quit();
	}

}

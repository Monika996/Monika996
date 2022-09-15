package p14_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
//	4.Zadatak
//	Ucitava stranicu https://demoqa.com/login
//	Loginuje se sa usename itbootcamp i lozinkom ITBootcamp2021!
//	Zatim ceka 5sekundi da se korisnik uloguje
//	Proverava da li se korisnik ulogovao, tako sto se proverava postojanje dugmeta Logout. Ispisati odgovarajucu poruku u konzoli za rezultat loginovanja.
//	Klikce na dugme za logout
//	Gasi stranicu

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(" https://demoqa.com/login ");

		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("Password")).sendKeys("ITBootcamp2021!");
		driver.findElement(By.id("login")).click();

		boolean logoutExist = driver.findElements(By.id("submit")).size() > 0;

		if (logoutExist) {
			System.out.println("Uspesno!");
		} else {
			System.out.println("Neuspesno!");
		}

		Thread.sleep(5000);
		driver.quit();

	}

}

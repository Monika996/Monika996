package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zad
//		Napisati program koji:
//		Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//		Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje odgovarajuce poruke (OVO JE POTREBNO RESITI PETLJOM)
//		POMOC: Brisite elemente odozdo.
//		(ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		List<WebElement> elementi = driver.findElements(By.xpath(("//*[contains(@class,'col-md-12')]")));

		for (int i = elementi.size()-1; i >= 0; i++) {
			elementi.get(i).findElement(By.className("close")).click();
			Thread.sleep(1000);

			boolean elementPostoji = true;

			try {
				driver.findElement(By.className("close"));
			} catch (Exception e) {
				elementPostoji = false;
			}
			if (elementPostoji) {
				System.out.println("Element postoji!");
			} else {
				System.out.println("Element ne postoji!");
			}
			
			driver.quit();
		}

	}

}

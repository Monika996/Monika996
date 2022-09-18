package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
//		1.Zad
//		Napisati program koji:
//		Pre nego sto krenete u automatizaciju prvo sve korake uradite rucno
//		Implicitno cekanje za trazenje elemenata je maksimalno 10s
//		Implicitno cekanje za ucitavanje stranice je 5s
//		Ucitava stranicu https://docs.katalon.com/
//		Maksimizuje prozor
//		Od html elementa cita data-theme atribut. 
//		Korisni linkovi za citanje vrednosti atributa link1 i link2
//		Proverava da li je sadrzaj u tom atributu light i ispisuje odgovarajuce poruke
//		Klikce na dugme za zamenu tema
//		Ponovo cita data-theme atribut html elementa i validira da u atributu stoji vrednost dark
//		Izvrsava kombinaciju tastera CTRL + K. Koristan link  za keyboard actions…kako izvrsavati precice preko Actions objekta
//		Zatim od inputa za pretragu cita atribut type i proverava da je vrednost tog atributa search
//		Zatvara pretrazivac

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://docs.katalon.com/");

		String theme = driver.findElement(By.tagName("html")).getAttribute("data-theme");
		if (theme.equals("light")) {
			System.out.println("Light thema");
		} else {
			System.out.println("Dark thema");
		}

		driver.findElement(By.className("toggleButton_rCf9")).click();

		theme = driver.findElement(By.tagName("html")).getAttribute("data-theme");
		if (theme.equals("light")) {
			System.out.println("Light thema");
		} else {
			System.out.println("Dark thema");
		}

		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();

		String searchType = driver.findElement(By.id("docsearch-input")).getAttribute("type");
		if (searchType.equals("search")) {
			System.out.println("Tip je dobar.");
		} else {
			System.out.println("Tip nije dobar.");
		}

		Thread.sleep(5000);
		driver.quit();
	}

}

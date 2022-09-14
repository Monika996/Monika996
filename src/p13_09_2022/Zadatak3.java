package p13_09_2022;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
//	3.Zadatak
//	Napisati program koji ima:
//	Niz stranica (niz stringova) koje treba da ucita. Niz je:
//	https://google.com/
//	https://youtube.com/
//	https://www.ebay.com/
//	https://www.kupujemprodajem.com/
//	Program petljom prolazi kroz niz stranica i svaku stranicu ucitava preko get ili navigate i od svake stranice na ekranu ispisuje naslov stranice. Kako od stranice procitati naslov imate na ovom linku
//	U prevodu u konzoli treba da se ispisu:
//	Google
//	YouTube
//	Electronics, Cars, Fashion, Collectibles & More | eBay
//	KupujemProdajem
//	Zatvara pretrazivac

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		ArrayList<String> links = new ArrayList<String>();
		links.add("https://google.com/\r\n");
		links.add("https://youtube.com/");
		links.add("https://www.ebay.com/\r\n");
		links.add("https://www.kupujemprodajem.com/\r\n");

		for (int i = 0; i < links.size(); i++) {
			driver.get(links.get(i));
			System.out.println(driver.getTitle());
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

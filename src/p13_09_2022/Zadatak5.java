package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
//	5.Zadatak
//	Napisti program koji:
//	Ucitava stranicu https://s.bootsnipp.com/iframe/z80en
//	Hvata sve elemente prve kolone i stampa tekst svakog elementa. Kako da od nekog elementa procitamo tekst imate na sledecem linku 
//	Ceka 1s
//	Hvata sve elemente prvog reda i stampa tekst svakog elementa 
//	Ceka 5s
//	Zatvara pretrazivac

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://s.bootsnipp.com/iframe/z80en");
		List<WebElement> row = driver.findElements(By.xpath("//*[@id='lorem']/table/tbody/tr[1]/td"));
		for (int i = 0; i < row.size(); i++) {
			System.out.print(row.get(i).getText() + " ");
			Thread.sleep(1000);
		}
		List<WebElement> column = driver.findElements(By.xpath("//*[@id='lorem']/table/tbody/tr/td[1]"));
		for (int i = 0; i < column.size(); i++) {
			System.out.println(column.get(i).getText());
		}
		Thread.sleep(5000);
		driver.quit();
	}

}

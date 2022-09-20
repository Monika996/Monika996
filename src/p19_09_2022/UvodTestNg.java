package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UvodTestNg {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	} // podesavamo drajver koji ce se koristiti ispod implicitno, eksplicitno,
		// firefox, actions..)

	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://www.google.com/");
	} // zove se pre svakog testa u klasi

	@Test(priority = 1)
	public void openHomePage() {

		driver.get("https://www.google.com/");

		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";

		// provera - za to koristimo aserte! Ovo su tvrdi asserti.
		Assert.assertEquals(actualTitle, expectedTitle, "EROR: Unexpected title.");
		// ako hocemo da znamo da li je test prosao moramo da ubacimo provere
		// ukoliko se provera ne ispuni, javice se AssertionError.
		// kada se desi AssertionError nas test staje, samo se prekida izvrsenje tog
		// trenutnog testa

		String actualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String expectedLang = "eng";

		Assert.assertEquals(actualLang, expectedLang, "ERROR: Language should be english.");

	}

	@Test
	public void search() {
		System.out.println("Test 2");
	}

	@Test(priority = 20)
	public void addProduct() {
		System.out.println("Test 3");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	} // proveravamo stanje testa (neko dokumentovanje testa)

	@AfterClass
	public void afterClass() {
		System.out.println("After class");

		driver.quit();
	}

}

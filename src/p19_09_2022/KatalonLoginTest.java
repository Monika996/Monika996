package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTest {
//	1.Zadatak
//	Kreirati klasu KatalonLoginTests za testove
//	Base url: https://cms.demo.katalon.com
//	Test #1: Visit login page from Nav bar
//	Koraci:
//	Ucitati home stranicu
//	Kliknuti na My account link
//	Verifikovati da je naslov stranice My account – Katalon Shop
//	Verifikovati da se u url-u stranice javlja /my-account
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get("baseUrl");
	}

	@Test(priority = 100)
	public void visitLoginPageFromMyNavBar() {
		driver.findElement(By.xpath(("//*[contains(@class,'page_item page-item-10 current_page_item')]"))).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account - Katalon";

		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://cms.demo.katalon.com/my-account/";
		boolean contains = expectedUrl.contains(actualUrl);

		Assert.assertTrue(contains, "ERROR: Unespected URL.");
	}

//	Test #2: Check input types
//	Koraci:
//	Ucitati /my-account stranicu 
//	Verifikovati da  polje za unos email-a za atribu type ima vrednost text
//	Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//	Verifikovati da checkbox Remember me za atribut type ima vrednost checkbox
//	Verifikovati da je Remember me checkbox decekiran. Koristan link kako naci informaciu da li je checkbox cekiran ili ne.
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske

	@Test(priority = 200)
	public void CheckInputTypes() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "/my-account";
		boolean check = actualTitle.contains(expectedTitle);
		Assert.assertTrue(check, "ERROR: Unexpected title.");

		String actualEmail = driver.findElement(By.id("username")).getAttribute("type");
		String expectedEmail = "text";
		Assert.assertEquals(actualEmail, expectedEmail, "ERROR: Type should be text.");

		String actualPassword = driver.findElement(By.id("password")).getAttribute("type");
		String expectedPassword = "password";
		Assert.assertEquals(actualPassword, expectedPassword);

		String actualCheckBox = driver.findElement(By.id("rememberme")).getAttribute("type");
		String expectedCheckBox = "checkbox";
		Assert.assertEquals(actualCheckBox, expectedCheckBox);

		WebElement checkbox = driver.findElement(By.id("rememberme"));
		boolean isSelected = checkbox.isSelected();
		Assert.assertFalse(isSelected);
	}

//	Test #3: Display error when credentials are wrong
//	Podaci: 
//	email: invalidemail@gmail.com
//	password: invalid123
//	Koraci: 
//	Ucitati /my-account stranicu
//	Unesite email
//	Unesite password
//	Kliknite na login dugme
//	Verifikovati da postoji element koji prikazuje gresku
//	Verifikovati da je prikazana greska ERROR: Invalid email address
//	Za sve validacije ispisati odgovarajuce poruke u slucaju greske
//	Verifikovati da smo idalje na login stranici posle greske, tako sto proveravamo da se url-u javlja /my-account

	@Test(priority = 300)
	public void displayErrorWhenCredentialsAreWrong() {
		driver.get(baseUrl + "/my-account");
		driver.findElement(By.xpath(("//*[contains(@name,'username')]"))).sendKeys(" invalidemail@gmail.com");
		driver.findElement(By.xpath(("//*[contains(@name,'password')]"))).sendKeys("invalid123");
		driver.findElement(By.xpath(("//*[contains(@type,'submit')]"))).click();

		// boolean hasError =
		// driver.findElements(By.className("woocommerce-error")).size() >= 0;
		// Assert.assertFalse(hasError, "");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-error")));

		Assert.assertEquals(driver.findElement(By.className("woocommerce-error")).getText(),
				"ERROR: Invalid email address. Lost your password?",
				"Error is not displayed when credentials are invalid.");

		Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Not on my account page.");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
	
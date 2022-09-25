package d20_09_2022_tests;



import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.HeaderPage;
import d20_09_2022_pages.LayerCartPage;
import d20_09_2022_pages.TopMenuPage;

public class AutomationPracticeTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "http://automationpractice.com";
	private BuyBoxPage buyBoxPage;
	private LayerCartPage layerCartPage;
	private TopMenuPage topMenuPage;
	private HeaderPage headerPage;
	private Actions actions;
	private SoftAssert softAssert;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseUrl);
		buyBoxPage = new BuyBoxPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
		topMenuPage = new TopMenuPage(driver, wait);
		headerPage = new HeaderPage(driver, wait);
		actions = new Actions(driver);
		softAssert = new SoftAssert();

	}

	@BeforeMethod
	public void beforeMethod() {

	}
//	Kreirati klasu AutomationPracticeTests 
//	baseUrl: http://automationpractice.com/
//		Test #1:  Adding product to the cart
//	Ucitati stranicu /index.php?id_product=1&controller=product
//	Odskrolati do buy box-a
//	Postavite kolicinu na 3
//	Izaberite velicinu L
//	Izaberite plavu boju
//	Kliknite na dugme add to cart
//	Cekajte da dijalog layer cart bude vidljiv
//	Verifikovati da je kolicina iz layer cart dijalog 3
//	Verifikovati da je velicina L
//	Verifikovati da je izabran proizvod sa plavom bojom
//	Verifikovati da je total price 3 puta veci od cene proizvoda
//	Kliknite na dugme continue shopping
//	cekajte da dijalog layer cart postane nevidljiv
//	Izaberite novi proizvod sa kolicinom 1, velicinom S i bojom Organe
//	Kliknite na dugme add to cart
//	Cekajte da dijalog bude vidljiv
//	kliknite na dugme proceed to checkout
//	Verifikujte da je naslov stranice Order - My Store

	@Test(priority = 10)
	public void addingProductToTheCart() {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");

		// scroll to buy box
		buyBoxPage.scrollToElement();

		// set quantity to 3
		buyBoxPage.getInputQuantity().clear();
		buyBoxPage.getInputQuantity().sendKeys("3");

		// choose size L
		buyBoxPage.getSize().selectByVisibleText("L");

		// choose blue color
		buyBoxPage.getColorElement("Blue").click();

		// click button add to cart
		buyBoxPage.getAddToCartButton().click();

		// wait for layer cart to be vissiable
		layerCartPage.waitForElementVisibility();

		// verify quantity
		String actualQuantity = layerCartPage.getQuantityAttribute().getText();
		String expectedQuantity = "3";
		Assert.assertEquals(actualQuantity.contains(expectedQuantity), "Quantity should be 3");

		// verify that size is L
		String actualSize = layerCartPage.getProductAttribute().getText();
		String expectedSize = "L";
		Assert.assertTrue(actualSize.contains(expectedSize), "Size should be L");

		// verify that choosen product is color: blue
		String actualColor = layerCartPage.getProductAttribute().getText();
		String expectedColor = "Blue";
		Assert.assertTrue(actualColor.contains(expectedColor), "Color should be blue.");

		// remove $, verify if total price is the same as product price * 3
		String totalPriceText = layerCartPage.getTotalPrice().getText().replaceAll("$", "");
		double totalPrice = Double.parseDouble(totalPriceText);
		String productPriceText = buyBoxPage.getProductPrice().getText().replaceAll("[$]", "");
		double productPrice = Double.parseDouble(productPriceText);
		Assert.assertTrue(totalPrice == productPrice * 3, "Total price should be 3 * the Product price");

		// click button continue shopping
		layerCartPage.getContinueShoppingButton().click();

		// wait for dialog layer cart to be invisiable
		layerCartPage.waitForElementInvisibility();

		// choose new product (quantity: 1, size: "S", Color: Orange)
		buyBoxPage.getInputQuantity().clear();
		buyBoxPage.getInputQuantity().sendKeys("1");
		buyBoxPage.getSize().selectByVisibleText("S");
		buyBoxPage.getColorElement("Orange").click();

		// clik button add to cart
		buyBoxPage.getAddToCartButton().click();

		// wait layer page to be visible
		layerCartPage.waitForElementVisibility();

		// click button proced to checkout
		layerCartPage.getProceedToCheckoutButton().click();

		// verify that title on the page is "Order - My store"
		String actualTitle = driver.getTitle();
		String expectedTitle = "My order";
		Assert.assertEquals(actualTitle, expectedTitle, "The title should be 'Order - My store' ");
	}

//	Test #2:  Top menu mouse over
//Predjite misem preko women linka. Koristan link kako da predjete misem preko nekog elementa link
//Verifikujte da je podmeni za women deo vidljiv
//Predjite misem preko dresses linka. 
//Verifikujte da je podmeni za dresses deo vidljiv
//Predjite misem preko t-shirts linka. 
//Verifikujte podmeniji za womens i dresses nevidljivi
//Ukoliko je potrebno ukljucite odgovarajuca cekanja, kojim bi se sacekalo da stranica dodje u odgovarajuce stanje
//Provera preko za vidljivost preko soft assert-a

	// test 2
	@Test(priority = 20)
	public void topMenuMouseOver() {
		// go over women link with mouse
		actions.moveToElement(topMenuPage.getWomenLink()).perform();

		// Verify that women submenu is visible
		softAssert.assertTrue(topMenuPage.getWomenSubMenuLink().isDisplayed(), "Women submenu should be displayed");

		// go over dresses link with mouse
		actions.moveToElement(topMenuPage.getDressesLink()).perform();

		// verify that dresses submenu is visible
		softAssert.assertTrue(topMenuPage.getDressesSubMenuLink().isDisplayed(), "Dresses submenu should be displayed");

		// go over t-shirt link with mouse
		actions.moveToElement(topMenuPage.getTshirtsLink()).perform();

		// verify that submenu for womens and dresses is invisible
		softAssert.assertFalse(
				topMenuPage.getWomenSubMenuLink().isDisplayed() && topMenuPage.getDressesSubMenuLink().isDisplayed(),
				"Women submenu and Dresses submenu should be displayed");
	}

//	Test #3:  Phone number visibility check on resize
//Maksimizujte prozor
//Proverite da je element za broj telefona vidljiv
//Smanjite dimenziju pretrazivaca na velicinu 767 x 700
//Proverite element za broj telefona nije vidljiv
//Promenite dimenziju pretrazivaca na 768 x 700
//Proverite da je broj telefona vidljiv
//Maksimizujte prozor
//Provera preko soft asserta
//	

	@Test(priority = 30)
	public void phoneNumberVisibilityCheckOnResize() {
		// maximize window
		driver.manage().window().maximize();

		// check if element for phone number is visible
		softAssert.assertTrue(headerPage.getShopPhoneNumber().isDisplayed(),
				"Element for phone number should be displayed");

		// reduce the size of browser
		driver.manage().window().setSize(new Dimension(767, 700));

		// check if element for phone number isn't visible
		softAssert.assertFalse(headerPage.getShopPhoneNumber().isDisplayed(),
				"Element for phone number should not be displayed");

		// change size of browser
		driver.manage().window().setSize(new Dimension(768, 700));

		// maximize window
		driver.manage().window().maximize();
	}

//	Test #4:  Header links check
//	Kliknite na contact us link
//	Verifikujte da je naslov stranice Contact us - My Store
//	Kliknite na sign in link
//	Verifikujte da je naslov stranice Login - My Store
//	Provera preko soft asserta

	@Test(priority = 40)
	public void headerLinksCheck() {

		// click on link Contact Us
		headerPage.getContactUsLink().click();

		// verify that title is Contact us - My store
		String actualTitle = driver.getTitle();
		String expectedTitle = "Contact us - My store";
		softAssert.assertEquals(actualTitle, expectedTitle, "The title should be Contact us - My store");

		// click on sign in link
		headerPage.getSignInLink().click();

		// verify that title is Login - My Store
		String expectedLoginTitle = "Login - My Store";
		String actualLoginTitle = driver.getTitle();
		softAssert.assertEquals(actualLoginTitle, expectedLoginTitle, "Title should be 'Login - My Store'");

	}

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}

package prabhash.testsClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import prabhash.pages.*;
import prabhash.utilsFiles.ExtentManager;
import prabhash.utilsFiles.RandomDataUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class ECommerceTest {

	private WebDriver driver;
	private ExtentReports extent;
	private ExtentTest test;
	String randomMobileNumber = RandomDataUtils.generateRandomMobileNumber();
	String randomEmail = RandomDataUtils.generateRandomEmail();

	@BeforeSuite
	public void setupReport() {
		extent = ExtentManager.createInstance("extentReport.html");
	}

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://trulyfreehome.dev");
		this.randomMobileNumber = RandomDataUtils.generateRandomMobileNumber();
		this.randomEmail = RandomDataUtils.generateRandomEmail();
	}

	@Test(priority = 1)
	public void signUpTest() throws InterruptedException {
		test = extent.createTest("Sign Up Test");

		HomePage homePage = new HomePage(driver);
		homePage.signUp(randomMobileNumber, "Prabhash", "Kumar", randomEmail, "1111");

		test.pass("Sign up completed successfully.");
	}

	@Test(priority = 2)
	public void navigateToEmaniBrand() {
		test = extent.createTest("Navigate to Emani Brand");

		BrandPage brandPage = new BrandPage(driver);
		brandPage.navigateToEmaniBrand();

		test.pass("Navigated to Emani Brand successfully.");
	}

	@Test(priority = 3)
	public void productListTest() throws IOException {
		test = extent.createTest("Product List Test");

		PLPPage plpPage = new PLPPage(driver);
		plpPage.printProductDetailsToExcel("products.xlsx");
		plpPage.selectAnyProduct();

		test.pass("Product details printed to Excel and a product selected.");
	}

	@Test(priority = 4)
	public void productDetailsPageTest() throws InterruptedException {
		test = extent.createTest("Product Details Page Test");

		PDPPage pdpPage = new PDPPage(driver);

		pdpPage.changeQuantity("5");
		pdpPage.addToCart();

		Assert.assertTrue(pdpPage.isCartCountUpdated("5"), "Cart count not updated");
		test.pass("Product details page actions completed successfully.");
	}

	@Test(priority = 5)
	public void cartPageTest() {
		test = extent.createTest("Cart Page Test");

		CartPage cartPage = new CartPage(driver);
		cartPage.clickOnCartIcon();
		Assert.assertTrue(cartPage.isProductDisplayedInCart(), "Product not displayed in cart");
		String expectedPrice = "4000.00";
		Assert.assertTrue(cartPage.isProductPriceCorrect(expectedPrice), "Product price mismatch");

		cartPage.proceedToCheckout();
		test.pass("Cart page actions completed successfully.");
	}

	@Test(priority = 6)
	public void checkoutTest() {
		test = extent.createTest("Checkout Test");

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.fillShippingDetails("Prabhash", "Kumar", randomMobileNumber, "abcef" + randomEmail,
				"24 Battery PI", "10004");

		test.pass("Checkout actions completed successfully.");
	}

	@Test(priority = 7)
	public void paymentPageTest() throws InterruptedException {
		test = extent.createTest("Payment Page Test");

		PaymentPage paymentPage = new PaymentPage(driver);

		paymentPage.addNewCard();
		paymentPage.enterCardDetails("Prabhash Kumar", "4242 4242 4242 4242", "111", "05", "2026");
		paymentPage.confirmOrder();

		paymentPage.closeExclusiveDeals();

		Thread.sleep(8000);
		test.pass("Payment page actions completed successfully.");
	}

	@Test(priority = 8)
	public void placeOrderTest() {
		test = extent.createTest("Place Order Test");

		OrderPage orderPage = new OrderPage(driver);

		String orderId = orderPage.getOrderId();
		Assert.assertNotNull(orderId, "Order ID not generated");
		Assert.assertFalse(orderId.isEmpty(), "Order ID is empty");

		test.pass("Order placed successfully.");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void tearDownReport() {
		extent.flush();
	}
}

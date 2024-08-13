package prabhash.pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PLPPage extends BasePage {

	@FindBy(css = ".card_title")
	private List<WebElement> productNames;

	@FindBy(css = ".stroke")
	private List<WebElement> productPrices;

	@FindBy(xpath = "//*[text()='Perfect Skin Kit']")
	private WebElement anyProduct;

	public PLPPage(WebDriver driver) {
		super(driver);
	}

	public void printProductDetailsToExcel(String filePath) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(productNames));
		wait.until(ExpectedConditions.visibilityOfAllElements(productPrices));

		XSSFWorkbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Product Details");

		int rowNum = 0;
		Row headerRow = sheet.createRow(rowNum++);
		headerRow.createCell(0).setCellValue("Product Name");
		headerRow.createCell(1).setCellValue("Product Price");

		for (int i = 0; i < productNames.size(); i++) {
			WebElement productName = productNames.get(i);
			WebElement productPrice = productPrices.get(i);

			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(productName.getText());
			row.createCell(1).setCellValue(productPrice.getText().substring(1));
		}

		FileOutputStream fileOut = new FileOutputStream(filePath);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}

	public void selectAnyProduct() {
		anyProduct.click();
	}
}

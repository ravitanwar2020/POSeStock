package testscript2;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testscipt {
	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);

		driver.manage().window().maximize();
		driver.get("http://18.140.214.202:9000/login");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		System.out.println("checked");

		driver.findElement(By.name("username")).sendKeys("posistentp_outlet1");

		driver.findElement(By.name("password")).sendKeys("Outlet1@");

		driver.findElement(By.xpath("//strong[@title='Close the keyboard']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		Thread.sleep(6000);

		driver.findElement(By.xpath("//button[@data-bb-handler='cancel']")).click();
		System.out.println("working login");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
		driver.findElement(By.xpath("//a[@ng-href='/eStock']")).click();
		System.out.println("enter into the stock");
	}

	@Test(priority = 1)
	public void stockentry() throws InterruptedException {

		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on stock enrty");

		driver.findElement(By.xpath("//div[@ng-click='performStockEntry()']")).click();
		System.out.println("select store");
		WebElement store_drpdown = driver.findElement(By.name("store"));
		Select sel1 = new Select(store_drpdown);
		sel1.selectByVisibleText("Main Store");
		WebElement vendor_drpdown = driver.findElement(By.name("vendor"));
		Select sel2 = new Select(vendor_drpdown);
		sel2.selectByVisibleText("Chatvinder");
		System.out.println("vendor selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[1]")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary ng-binding ng-scope']")).click();
		System.out.println("submitted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[1]")).click();
		System.out.println("stock entry done");

	}

	@Test(priority = 6)
	public void semiprocessed() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("//li[@ng-click='resetSemiProcessedFoodEntryTab()']/a[@ng-click='select()']"))
				.click();

		driver.findElement(By.xpath("//div[@ng-click='performSemiProcessedFoodEntry()']")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		WebElement dropdown = driver.findElement(By.xpath("(//select[@name='store'])[5]"));
		Select sel1 = new Select(dropdown);
		sel1.selectByVisibleText("Rtkitchen");
		System.out.println("kitchen selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='0'])[7]")).click();
		System.out.println("category  selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[10]")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary ng-binding ng-scope']")).click();
		// driver.findElement(By.xpath("//button[@class='btn btn-warning
		// ng-hide']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
//		System.out.println("qty checked");
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='modal-footer
//		 ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("semiprocessed entry done");

	}

	@Test(priority = 7)
	public void processed() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("(//a[@ng-click='select()'])[7]")).click();

		driver.findElement(By.xpath("//div[@ng-click='performProcessedFoodEntry()']")).click();
		System.out.println("enter details");

		WebElement dropdown = driver.findElement(By.xpath("(//select[@name='store'])[4]"));
		Select sel1 = new Select(dropdown);
		sel1.selectByVisibleText("Rtkitchen");
		System.out.println("kitchen selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='1'])[7]")).click();
		System.out.println("category  selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[10]")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button [@class='btn btn-primary']")).click();

		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@class='modal-footer
		// ng-scope']/a[@ng-click='submit(true)']")).click();
		// System.out.println("qty checked");
		// Thread.sleep(5000);
		// driver.findElement(By.xpath("//div[@class='modal-footer
		// ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("processedfood entry done");

	}

	@Test(priority = 3)
	public void physicalstock() throws InterruptedException

	{
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("//li[@ng-click='resetPhysicalStockTab()']/a[@ng-click='select()']")).click();

		driver.findElement(By.xpath("//div[@ng-click='performPhysicalStock()']")).click();

		WebElement dropdown = driver.findElement(By.xpath("(//select[@name='store'])[3]"));
		Select sel1 = new Select(dropdown);
		sel1.selectByVisibleText("Kitchen veg");
		System.out.println("store selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='14']")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[7]")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("qty checked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("physical entry done");

	}

	@Test(priority = 8)
	public void openingstock() throws InterruptedException

	{
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("//li[@ng-click='resetOpeningStockTab()']/a[@ng-click='select()']")).click();

		driver.findElement(By.xpath("//div[@ng-click='performOpeningStock()']")).click();

		WebElement dropdown = driver.findElement(By.xpath("(//select[@name='storeKitchen'])[3]"));
		Select sel1 = new Select(dropdown);
		sel1.selectByVisibleText("Kitchen Non veg");
		System.out.println("store selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='9'])[4]")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[49]")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[50]")).sendKeys("10");
		Thread.sleep(2000);
		System.out.println("unit price entered");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		// System.out.println("qty checked");
		// Thread.sleep(000);
		// driver.findElement(By.xpath("//div[@class='modal-footer
		// ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("opening stock entry done");

	}

	@Test(priority = 5)
	public void stocktransfer() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("//li [@ng-click='resetStockTransferTab()']/a[@ng-click='select()']")).click();

		driver.findElement(By.xpath("//div[@ng-click='performStockTransfer()']")).click();
		System.out.println("enter stock transfer qty");

		Select sel1 = new Select(driver.findElement(By.xpath("(//Select[@name='storeKitchen'])[2]")));

		sel1.selectByVisibleText("Main Store");
		System.out.println("store selected");

		Select sel2 = new Select(driver.findElement(By.xpath("//Select[@name='toStore']")));

		sel2.selectByVisibleText("Rtkitchen");
		System.out.println("kitchen selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@id='17'])[3]")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[10]")).sendKeys("10");
		System.out.println("quantity entered");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/span[@class='ng-binding']")).click();
		System.out.println("submitted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		System.out.println("stock transfer done");

	}

	@Test(priority = 4)
	public void wastage() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on entries");

		driver.findElement(By.xpath("//li [@ng-click='resetWastageTab()']/a[@ng-click='select()']")).click();

		driver.findElement(By.xpath("//div[@ng-click='performWastage()']")).click();
		System.out.println("enter wastage qty");

		Select sel1 = new Select(driver.findElement(By.xpath("(//select[@name='storeKitchen'])[1]")));
		sel1.selectByVisibleText("Rtkitchen");
		System.out.println("store selected");

		Select sel2 = new Select(driver.findElement(By.xpath("//select[@name='wastageType']")));
		sel2.selectByVisibleText("Wastage");
		System.out.println("wastage type selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='52']")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[9]")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']/span[@class='ng-binding']")).click();
		System.out.println("submitted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[@ng-click='submit(true)']")).click();
		Thread.sleep(2000);
		System.out.println("wastage qty entered");

	}

	@Test(priority = 2)
	public void stocksale() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@ui-sref='.entries']")).click();
		System.out.println("clicked on  enrtries");
		driver.findElement(By.xpath("//li[@ng-click='resetStockSaleTab()']/a[@ng-click='select()']")).click();
		System.out.println("clicked on stock sale");

		driver.findElement(By.xpath("//div[@ng-click='performStockSale()']")).click();
		WebElement store_drpdown = driver.findElement(By.xpath("(//select[@name='store'])[2]"));

		Select sel1 = new Select(store_drpdown);
		sel1.selectByVisibleText("Main Store");
		System.out.println("store selected");
		WebElement vendor_drpdown = driver.findElement(By.name("receiver"));
		Select sel2 = new Select(vendor_drpdown);
		sel2.selectByVisibleText("Mr Rectest");
		System.out.println("vendor selected");
		driver.findElement(By.xpath("(//input[@id='1'])[2]")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[5]")).sendKeys("1");
		System.out.println("price entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println("invoice no. not fill up");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("qty checked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("stock sale going to be complete");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("stock over");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("stock sale done");
	}

	@Test(priority = 9)
	public void purchaseentry() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.purchaseOrder']")).click();
		System.out.println("clicked on stock enrty");
		Thread.sleep(2000);
		WebElement drp_down = driver.findElement(By.name("vendor"));
		Select s1 = new Select(drp_down);
		s1.selectByVisibleText("Chatvinder");
		System.out.println("vendor selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@datepicker-popup='dd-MM-yyyy']")).click();
		String exp_month = "August 2020";
		String exp_date = "15";
		while (true) {
			String curr_month = driver.findElement(By.xpath("(//strong[@class='ng-binding'])[1]")).getText();
			if (curr_month.equals(exp_month)) {
				break;
			} else {
				driver.findElement(By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[1]")).click();

			}

		}

		driver.findElement(By.xpath("(//td[@role='gridcell']/button/span[text()='05'])[1]")).click();
		System.out.println("ordering for date selected");
		Thread.sleep(2000);
		driver.findElement(By.id("5d907d8b28b05f7e2805e795")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("qty_5dadaa4c5bf0228fe4694d7d")).sendKeys("10");
		Thread.sleep(2000);
		System.out.println("qty entered");
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-binding']")).click();

		Alert alt = driver.switchTo().alert();
		alt.accept();

		Alert alt2 = driver.switchTo().alert();
		alt2.accept();
		System.out.println("purchase order entry done");

	}

	@Test(priority = 10)
	public void indent() throws InterruptedException

	{

		driver.findElement(By.xpath("//a[@ui-sref='.indent']")).click();
		System.out.println("clicked on indent");
		Thread.sleep(4000);
		WebElement drp_down = driver.findElement(By.name("baseKitchen"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("bk1");
		System.out.println("base kitchen  selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@datepicker-popup='dd-MM-yyyy']")).click();
		String exp_month = "August 2020";
		String exp_date = "15";
		while (true) {
			String curr_month = driver.findElement(By.xpath("(//strong[@class='ng-binding'])[1]")).getText();
			if (curr_month.equals(exp_month)) {
				break;
			} else {
				driver.findElement(By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[1]")).click();

			}
			System.out.println("calander selected");

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@role='gridcell']/button/span[text()='05'])[1]")).click();
		System.out.println("ordering for date selected");
		Thread.sleep(2000);
		driver.findElement(By.id("5d907d8b28b05f7e2805e795")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("qty5daac2faf4d1ae535694898f")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-success ng-binding ng-scope']")).click();
		System.out.println("submitted");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("btn clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-right']")).click();
		System.out.println("2nd btn clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-success ng-binding ng-scope']")).click();
		System.out.println("indent generated");

	}

	@Test(priority = 11)
	public void internalindent() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.internalIndenting']")).click();
		System.out.println("clicked on internal indent");

		WebElement drp_down = driver.findElement(By.name("toStoreKitchen"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Rtkitchen");
		System.out.println("store selected");

		WebElement drp_down2 = driver.findElement(By.name("storeKitchen"));
		Select sel2 = new Select(drp_down2);
		sel2.selectByVisibleText("Main Store");
		System.out.println("store from selected");

		driver.findElement(By.id("5d907d8b28b05f7e2805e795")).click();
		System.out.println("category selected");
		driver.findElement(By.name("qty5daac300f4d1ae53569489b7")).sendKeys("10");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-scope']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		Alert alt2 = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-scope']")).click();
		System.out.println("internal indent generated");
	}

	@Test(priority = 12)
	public void salesorder() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.salesOrder']")).click();

		WebElement drp_down = driver.findElement(By.name("receiver"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Mr Rectest");
		System.out.println("vendor selected");
		Thread.sleep(2000);
		driver.findElement(By.id("5d907d8b28b05f7e2805e795")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("qty_5daac300f4d1ae53569489b7")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		Alert alt1 = driver.switchTo().alert();
		Thread.sleep(2000);
		alt1.accept();
		System.out.println("sales order entry done");
	}

	@Test(priority = 13)
	public void editEntry() throws InterruptedException {

		driver.findElement(By.xpath("//a[@ui-sref='.editing']")).click();
		System.out.println("clicked on edit entries");
		Thread.sleep(2000);
		WebElement store_drpdown = driver.findElement(By.name("transactionType"));
		Select sel1 = new Select(store_drpdown);
		sel1.selectByVisibleText("Stock Entry");
		Thread.sleep(2000);
		WebElement vendor_drpdown = driver.findElement(By.name("vendor"));
		Select sel2 = new Select(vendor_drpdown);
		sel2.selectByVisibleText("Chatvinder");
		System.out.println("vendor selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-binding']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@class='text-success ng-binding ng-scope'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("quantity")).sendKeys("10");
		System.out.println("qty changed");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary ng-binding ng-scope']")).click();
		System.out.println("stock entry done");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='modal-footer ng-scope']/a[1]")).click();
		System.out.println("edit entry done");

	}

	@Test(priority = 14)
	public void purchaseRequisition() throws InterruptedException {

		driver.findElement(By.xpath("//a[@ui-sref='.purchaseRequisition']")).click();
		Thread.sleep(2000);
		WebElement drp_down = driver.findElement(By.xpath("//select[@name='purchase']"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("PR");
		System.out.println("PR selected");
		driver.findElement(By.xpath("//input[@datepicker-popup='dd-MM-yyyy']")).click();
		String exp_month = "August 2020";
		String exp_date = "15";
		while (true) {
			String curr_month = driver.findElement(By.xpath("(//strong[@class='ng-binding'])[1]")).getText();
			if (curr_month.equals(exp_month)) {
				break;
			} else {
				driver.findElement(By.xpath("(//button[@class='btn btn-default btn-sm pull-right'])[1]")).click();

			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//td[@role='gridcell']/button/span[text()='05'])[1]")).click();
		System.out.println("ordering for date selected");
		Thread.sleep(2000);
		driver.findElement(By.id("5ef495545fba356806efaa42")).click();
		System.out.println("category selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-success ng-scope']")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		Alert alt1 = driver.switchTo().alert();
		alt1.accept();
		System.out.println("alert handled");

	}

	@Test(priority = 15)
	public void recipeReport() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@ui-sref='.recipeReport']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-binding']")).click();
		System.out.println("Recipe report generated");

	}

	@Test(priority = 16)
	public void cutCodeProcessing() throws InterruptedException {

		driver.findElement(By.xpath("//a[@ui-sref='.cutCodeProcessing']")).click();
		System.out.println("cutcode processing clicked");
		Thread.sleep(2000);
		WebElement drp_down = driver.findElement(By.name("store"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Cut Code Store1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		System.out.println("cutcode selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='number'])[2]")).sendKeys("10");
		System.out.println("qty entered");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		System.out.println("submitted");

	}

	@Test(priority = 17)
	public void localStockReturn() throws InterruptedException {

		driver.findElement(By.xpath("//a[@ui-sref='.localStockReturn']")).click();
		System.out.println("local stock return selected");
		WebElement drp_down = driver.findElement(By.name("store"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Main Store");
		System.out.println("Main store selected");
		Thread.sleep(2000);
		WebElement drp_down2 = driver.findElement(By.name("vendor"));
		Select sel2 = new Select(drp_down2);
		sel2.selectByVisibleText("Chatvinder");
		System.out.println("vendor selected");
		driver.findElement(By.xpath("//a[@class='btn btn-primary ng-binding']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='text-primary ng-binding']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-binding ng-scope']")).click();
		System.out.println("clicked on return button");

	}

	@Test(priority = 18)
	public void payment() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.payment']")).click();
		System.out.println("Payment selected");
		WebElement drp_down = driver.findElement(By.name("vendor"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Chatvinder");
		System.out.println("vendor selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-success ng-binding']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='text-success ng-binding']")).click();
		System.out.println("pay button clicked");
		WebElement drp_down2 = driver.findElement(By.name("paymentMode"));
		Select sel2 = new Select(drp_down2);
		sel2.selectByVisibleText("Cash");
		System.out.println("Cash selected");
		Thread.sleep(2000);
		driver.findElement(By.name("paymentAmount")).sendKeys("10");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary ng-binding']")).click();
		System.out.println("payment successful");

	}

	@Test(priority = 19)
	public void reprint() throws InterruptedException {
		driver.findElement(By.xpath("//a[@ui-sref='.reprint']")).click();
		Thread.sleep(2000);
		WebElement drp_down = driver.findElement(By.name("module"));
		Select sel1 = new Select(drp_down);
		sel1.selectByVisibleText("Entries");
		System.out.println("module selected");
		Thread.sleep(2000);
		WebElement drp_down2 = driver.findElement(By.name("subModule"));
		Select sel2 = new Select(drp_down2);
		sel2.selectByVisibleText("Stock Entry");
		System.out.println("submodule selected");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn btn-primary pull-left ng-binding']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='btn text-success ng-binding']")).click();
		System.out.println("Reprint done");

	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}
}

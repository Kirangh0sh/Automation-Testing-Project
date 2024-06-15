package org.test;

import java.util.concurrent.TimeUnit;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CURA_WebApplication extends BaseClass {

	@BeforeMethod
	private void openBrowser() {
		launchBrowser();

	}

	@AfterMethod
	private void closeBrowser() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		CloseEntireBrowser();
	}

	@Test(priority = 0)
	private void tc1() {

		// Login Functionality

		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		MaxWindow();

		WebElement MakeApmnt = driver.findElement(By.id("btn-make-appointment"));
		clickBtn(MakeApmnt);
		WebElement UserName = driver.findElement(By.id("txt-username"));
		passText("John Doe", UserName);
		WebElement pass = driver.findElement(By.id("txt-password"));
		passText("ThisIsNotAPassword", pass);
		WebElement login = driver.findElement(By.id("btn-login"));
		clickBtn(login);

		try {
			Assert.assertEquals("https://katalon-demo-cura.herokuapp.com/#appointment", driver.getCurrentUrl());
		} catch (Exception e) {
			System.out.println("Login Failed!!!");
		}

	}

	@Test(priority = 1)
	private void tc2() throws InterruptedException {

		// Test case includes:Login, Select first option from the drop-down menu, Enable
		// the check box, Click in the radio button for medicare, Automate calendar for
		// the date 03/03/2038,
		// Add some text in the comment box, Click Book appointment button

		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		MaxWindow();

		WebElement MakeApmnt = driver.findElement(By.id("btn-make-appointment"));
		clickBtn(MakeApmnt);
		WebElement UserName = driver.findElement(By.id("txt-username"));
		passText("John Doe", UserName);
		WebElement pass = driver.findElement(By.id("txt-password"));
		passText("ThisIsNotAPassword", pass);
		WebElement login = driver.findElement(By.id("btn-login"));
		clickBtn(login);

		TimeUnit.SECONDS.sleep(3);

		// drop down
		WebElement dropDown = driver.findElement(By.id("combo_facility"));
		Select s = new Select(dropDown);
		s.selectByIndex(0);
		// check box
		WebElement chkBox = driver.findElement(By.id("chk_hospotal_readmission"));
		clickBtn(chkBox);
		// radio button
		WebElement medicare = driver.findElement(By.id("radio_program_medicare"));
		clickBtn(medicare);

		// calendar
		WebElement dateBox = driver.findElement(By.id("txt_visit_date"));
		clickBtn(dateBox);

		TimeUnit.SECONDS.sleep(3);

		WebElement dateSelector = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]"));
		clickBtn(dateSelector);
		String aYear = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).getText();

		while (!(aYear.equals("2038"))) {
			WebElement nextButton = driver.findElement(By.xpath("(//th[@class='next'])[2]"));
			clickBtn(nextButton);
			aYear = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).getText();
		}
		WebElement march = driver.findElement(By.xpath("//span[text()='Mar']"));
		clickBtn(march);
		WebElement day = driver.findElement(By.xpath("(//td[text()='3'])[1]"));
		clickBtn(day);

		// Comment Box
		WebElement cmntBox = driver.findElement(By.id("txt_comment"));
		passText("New appointment for John Doe", cmntBox);
		// Book appointment
		driver.findElement(By.id("btn-book-appointment")).click();

		String expectedUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";

		try {
			Assert.assertEquals(pageUrl(), expectedUrl);
		} catch (Exception e) {
			System.out.println("Booking Failed");
		}

	}

	@Test(priority = 2)

	// Test case includes:Login, Select Third option from the drop-down menu, Enable
	// the check box, Click in the radio button for none, Send the value for the
	// date 21/12/2025
	// Add some text in the comment box, Click Book appointment button

	private void tc3() throws InterruptedException {
		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		MaxWindow();

		WebElement MakeApmnt = driver.findElement(By.id("btn-make-appointment"));
		clickBtn(MakeApmnt);
		WebElement UserName = driver.findElement(By.id("txt-username"));
		passText("John Doe", UserName);
		WebElement pass = driver.findElement(By.id("txt-password"));
		passText("ThisIsNotAPassword", pass);
		WebElement login = driver.findElement(By.id("btn-login"));
		clickBtn(login);

		TimeUnit.SECONDS.sleep(3);

		// drop down
		WebElement dropDown = driver.findElement(By.id("combo_facility"));
		Select s = new Select(dropDown);
		s.selectByIndex(2);
		// check box
		WebElement chkBox = driver.findElement(By.id("chk_hospotal_readmission"));
		clickBtn(chkBox);
		// radio button
		WebElement none = driver.findElement(By.id("radio_program_none"));
		clickBtn(none);
		// calendar
		WebElement apDate = driver.findElement(By.id("txt_visit_date"));
		passText("21/12/2025", apDate);
		// Comment Box
		WebElement cmntBox = driver.findElement(By.id("txt_comment"));
		passText("Need to see Doc ASAP!!!", cmntBox);
		// Book appointment
		driver.findElement(By.id("btn-book-appointment")).click();

		String expectedUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";

		try {
			Assert.assertEquals(pageUrl(), expectedUrl);
		} catch (Exception e) {
			System.out.println("Booking Failed");
		}

	}

	@Test(priority = 3)

	// Test case includes:Login, Select Second option from the drop-down menu,
	// Ignore the check box, Click in the radio button for Medicaid, Automate the
	// value for the date 03/12/2024
	// Add some text in the comment box, Click Book appointment button

	private void tc4() throws InterruptedException {

		launchUrl("https://katalon-demo-cura.herokuapp.com/");
		MaxWindow();

		WebElement MakeApmnt = driver.findElement(By.id("btn-make-appointment"));
		clickBtn(MakeApmnt);
		WebElement UserName = driver.findElement(By.id("txt-username"));
		passText("John Doe", UserName);
		WebElement pass = driver.findElement(By.id("txt-password"));
		passText("ThisIsNotAPassword", pass);
		WebElement login = driver.findElement(By.id("btn-login"));
		clickBtn(login);

		TimeUnit.SECONDS.sleep(3);

		// drop down
		WebElement dropDown = driver.findElement(By.id("combo_facility"));
		Select s = new Select(dropDown);
		s.selectByIndex(1);
		// radio button
		WebElement medicaid = driver.findElement(By.id("radio_program_medicaid"));
		clickBtn(medicaid);

		// calendar
		WebElement dateBox = driver.findElement(By.id("txt_visit_date"));
		clickBtn(dateBox);

		TimeUnit.SECONDS.sleep(3);

		WebElement dateSelector = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[1]"));
		clickBtn(dateSelector);
		String aYear = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).getText();

		while (!(aYear.equals("2024"))) {
			WebElement nextButton = driver.findElement(By.xpath("(//th[@class='next'])[2]"));
			clickBtn(nextButton);
			aYear = driver.findElement(By.xpath("(//th[@class='datepicker-switch'])[2]")).getText();
		}
		WebElement december = driver.findElement(By.xpath("//span[text()='Dec']"));
		clickBtn(december);
		WebElement day = driver.findElement(By.xpath("(//td[text()='3'])[1]"));
		clickBtn(day);

		TimeUnit.SECONDS.sleep(2);

		// Comment Box
		WebElement cmntBox = driver.findElement(By.id("txt_comment"));
		passText("Routine Check-up :)", cmntBox);
		// Book appointment
		driver.findElement(By.id("btn-book-appointment")).click();

		String expectedUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";

		try {
			Assert.assertEquals(pageUrl(), expectedUrl);
		} catch (Exception e) {
			System.out.println("Booking Failed");
		}

	}

}

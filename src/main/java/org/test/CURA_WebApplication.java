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

		//Test case includes:Login, Select first option from the drop-down menu, Enable the check box, Click in the radio button for medicare, Automate calendar for the date 03/03/2038
		
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
		

	}
	
	@Test
	private void tc3() {
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
	}

}

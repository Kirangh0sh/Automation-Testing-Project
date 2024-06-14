package org.pojo;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignINPojo extends BaseClass {

	public SignINPojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath =  "//a[text()='Create new account']")
	private WebElement createNewAcc;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement firstNmaeTxtBox;
	
	@FindBy(name = "lastname")
	private WebElement secondnameTxtBox;
	
	@FindBy(name = "reg_email__")
	private WebElement mobileOrEmailTxtBox;
	
	@FindBy(name = "reg_passwd__")
	private WebElement newPassword;

	public WebElement getCreateNewAcc() {
		return createNewAcc;
	}

	public WebElement getFirstNameTxtBox() {
		return firstNmaeTxtBox;
	}

	public WebElement getSecondnameTxtBox() {
		return secondnameTxtBox;
	}

	public WebElement getMobileOrEmailTxtBox() {
		return mobileOrEmailTxtBox;
	}

	public WebElement getNewPassword() {
		return newPassword;
	}

}

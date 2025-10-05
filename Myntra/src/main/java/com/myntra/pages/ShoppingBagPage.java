package com.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingBagPage {
@FindBy(xpath = "//button[text()='REMOVE']")
private WebElement removeOption1;
@FindBy(xpath = "//div[contains(@class,'confirmationModalDesktop')]/descendant::button[text()='REMOVE']")
private WebElement removeOption2;
@FindBy(className = "notifyText")
private WebElement popupMsg;
public ShoppingBagPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void setRemoveOption1() {
	removeOption1.click();
}
public void setRemoveOption2() {
	removeOption2.click();
}
public String getNotifyMsgText() {
	return popupMsg.getText();
}
}

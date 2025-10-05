package com.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDescriptionPage {
@FindBy(xpath = "//div[text()='ADD TO BAG']")
private WebElement addToBagBtn;
@FindBy(xpath = "//p[text()='Added to bag']")
private WebElement msg;
@FindBy(linkText = "GO TO BAG")
private WebElement goToBagBtn;
public ProductDescriptionPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getMsg() {
	return msg;
}
public void setAddToBag() {
	addToBagBtn.click();
}
public void setGoToBag() {
	goToBagBtn.click();
}
public boolean getMsgDisplayed() {
return msg.isDisplayed();
}
}

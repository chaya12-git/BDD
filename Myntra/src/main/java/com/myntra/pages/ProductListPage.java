package com.myntra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
@FindBy(className = "sort-sortBy")
private WebElement sortByEle;
@FindBy(xpath = "//label[text()=\"What's New\"]")
private WebElement whatsNewOption;
@FindBy(xpath = "//label[text()='10% and above']")
private WebElement discountRadio;
@FindBy(className = "product-sliderContainer")
private WebElement firstProduct;

public ProductListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getSortByEle() {
	return sortByEle;
}

public WebElement getWhatsNewOption() {
	return whatsNewOption;
}

public WebElement getDiscountRadio() {
	return discountRadio;
}

public WebElement getFirstProduct() {
	return firstProduct;
}

}

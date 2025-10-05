package stepdefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.myntra.pages.HomePage;
import com.myntra.pages.ProductDescriptionPage;
import com.myntra.pages.ProductListPage;
import com.myntra.pages.ShoppingBagPage;

import hooks.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	WebDriver driver=BaseClass.driver;
	ProductListPage p1;
	ProductDescriptionPage p2;
	ShoppingBagPage s;
	@Given("User should trigger {string}")
	public void user_should_trigger(String url) {
		driver.get(url);
	}

	@When("user searches for {string}")
	public void user_searches_for(String product) {
		HomePage h=new HomePage(driver);
		h.setProductSearchBox(product);
	}

	@Then("Product list page should be displayed")
	public void product_list_page_should_be_displayed() {
		Reporter.log(driver.getTitle(),true);
	}

	@When("he selects what is new option from the sort dropdown")
	public void he_selects_what_is_new_option_from_the_sort_dropdown() {
		p1=new ProductListPage(driver);
		WebElement sortBy = p1.getSortByEle();
		Actions a=new Actions(driver);
		a.moveToElement(sortBy).perform();
		p1.getWhatsNewOption().click();
	}

	@And("he selects a discount range")
	public void he_selects_a_discount_range() {
		p1.getDiscountRadio().click();
	}

	@And("he clicks on the first option")
	public void he_clicks_on_the_first_option() throws InterruptedException {
		Thread.sleep(2000);
		p1.getFirstProduct().click();
	}

	@Then("Product description page should be displayed")
	public void product_description_page_should_be_displayed() {
		Set<String> allWid = driver.getWindowHandles();
		for (String wid : allWid) {
			driver.switchTo().window(wid);	
		}
		Reporter.log(driver.getTitle(),true);
	}
	@When("he selects the size as {string}")
	public void he_selects_the_size_as(String size) {
		driver.findElement(By.xpath("//p[@class='size-buttons-unified-size' and text()='"+size+"']")).click();
	}
	@And("he clicks on add to bag button")
	public void he_clicks_on_add_to_bag_button() {
		p2=new ProductDescriptionPage(driver);
		p2.setAddToBag();
	}

	@Then("Added to bag popup should be displayed")
	public void added_to_bag_popup_should_be_displayed() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		boolean res = wait.until(ExpectedConditions.visibilityOf(p2.getMsg())).isDisplayed();
		Assert.assertTrue(res);
	}

	@When("he clicks on got to bag button")
	public void he_clicks_on_got_to_bag_button() {
		p2.setGoToBag();
	}

	@Then("Shopping bag page should be displayed")
	public void shopping_bag_page_should_be_displayed() {
		Reporter.log(driver.getTitle(),true);
	}

	@When("he clicks on remove button")
	public void he_clicks_on_remove_button() throws InterruptedException {
		s=new ShoppingBagPage(driver);
		s.setRemoveOption1();
		Thread.sleep(2000);
	}

	@And("he clicks on remove option in the popup")
	public void he_clicks_on_remove_option_in_the_popup() throws InterruptedException {
		s.setRemoveOption2();
		Thread.sleep(2000);
	}

	@Then("itemn removed message should be displayed")
	public void itemn_removed_message_should_be_displayed() {
		String text = s.getNotifyMsgText();
		String expectedText="1 item removed from bag.";
		Assert.assertEquals(text, expectedText);
	}
}
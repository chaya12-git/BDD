package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgottenPassword {
	WebDriver driver;
	@Given("User should be present in facebook login page")
	public void user_should_be_present_in_facebook_login_page() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com");
	}	@When("User clicks on forgotten password link")
	public void user_clicks_on_forgotten_password_link() {
		driver.findElement(By.linkText("Forgotten password?")).click();
	}	@Then("Forgotten password page should be displayed")
	public void forgotten_password_page_should_be_displayed() {
		String actualTitle = driver.getTitle();
		String expectedTitle="Forgotten Password | Can't Log In | Facebook";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}

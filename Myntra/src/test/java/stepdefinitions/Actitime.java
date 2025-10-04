package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Actitime {
	WebDriver driver;
@Given("User should be present in {string}")
public void user_should_be_present_in(String url) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get(url);
}

@When("he enters the username as {string}")
public void he_enters_the_username_as(String un) {
	driver.findElement(By.id("username")).sendKeys(un);
}

@When("he enters the password as {string}")
public void he_enters_the_password_as(String pwd) {
	driver.findElement(By.name("pwd")).sendKeys(pwd);
}

@When("he clicks on login button")
public void he_clicks_on_login_button() {
	driver.findElement(By.xpath("//div[text()='Login ']")).click();
}

@Then("home page should be displayed")
public void home_page_should_be_displayed() {
	System.out.println(driver.getTitle());
	driver.quit();
}
}

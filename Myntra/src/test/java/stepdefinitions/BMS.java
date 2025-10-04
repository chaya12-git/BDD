package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BMS {
	WebDriver driver;
@Given("User should be present in BMS home page")
public void user_should_be_present_in_bms_home_page() {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://in.bookmyshow.com/");
	}@When("He clicks on the option")
public void he_clicks_on_the_option() {
	driver.findElement(By.xpath("//p[text()='Bengaluru']")).click();
}@Then("The location selected popup should be displayed")
public void the_location_selected_popup_should_be_displayed() {
	String text = driver.findElement(By.xpath
	("//div[contains(text(),'Your location is updated to')]")).getText();
	System.out.println(text);
}


}

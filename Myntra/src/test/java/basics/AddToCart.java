package basics;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;

public class AddToCart {
public static void main(String[] args) throws InterruptedException {
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opt);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.myntra.com");
	driver.findElement(By.className("desktop-searchBar")).sendKeys("Shoes for men"+Keys.ENTER);
WebElement sortby = driver.findElement(By.className("sort-sortBy"));
Actions a=new Actions(driver);
a.moveToElement(sortby).perform();
	driver.findElement(By.xpath("//label[text()=\"What's New\"]")).click();
	WebElement radio = driver.findElement
(By.xpath("//label[text()='10% and above']"));
radio.click();
driver.findElement(By.className("product-sliderContainer")).click();
Set<String> allWid = driver.getWindowHandles();
for (String wid : allWid) {
	driver.switchTo().window(wid);	
}
driver.findElement(By.xpath("//p[@class='size-buttons-unified-size' and text()='8']")).click();
driver.findElement(By.xpath("//div[text()='ADD TO BAG']")).click();
boolean res1 = driver.findElement(By.xpath("//p[text()='Added to bag']")).isDisplayed();
driver.findElement(By.linkText("GO TO BAG")).click();
driver.findElement(By.xpath("//button[text()='REMOVE']")).click();Thread.sleep(2000);
driver.findElement(By.xpath
("//div[contains(@class,'confirmationModalDesktop')]/descendant::button[text()='REMOVE']")).click();
String text = driver.findElement(By.className("notifyText")).getText();
System.out.println(text);
driver.quit();
}
}

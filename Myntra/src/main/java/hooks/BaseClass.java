package hooks;

import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseClass {
	@Before(order=0)
public void openBrowser() {
	Reporter.log("openBrowser",true);
}
	@Before(order=1)
public void login() {
	Reporter.log("login",true);
}
	@After(order=1)
public void logout() {
	Reporter.log("logout",true);
}
	@After(order=0)
public void closeBrowser() {
	Reporter.log("closeBrowser",true);
}
}

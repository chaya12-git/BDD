package stepdefinitions;

import org.testng.Reporter;

import hooks.BaseClass;
import io.cucumber.java.en.Given;

public class Myntra {

@Given("Print title of myntra")
public void print_title_of_myntra() {
	Reporter.log("Myntra Home Page",true);
}
}

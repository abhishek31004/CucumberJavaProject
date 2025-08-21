package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	
	public WebDriver driver;
	public LoginPage loginpage;

	
	@Given("User Launch chrome Browser")
	public void user_launch_chrome_browser() {
		driver=new ChromeDriver();
		loginpage=new LoginPage(driver);
	    
	}

	@When("User opens The URLs {string}")
	public void user_opens_the_ur_ls(String url) {
		driver.get(url);
	  
	}

	@When("User enter Emails as {string} and Password as {string}")
	public void user_enter_emails_as_and_password_as(String emaiAdd, String password) {
	   loginpage.enterEmail(emaiAdd);
	   loginpage.enterPassword(password);
	}

	@When("Click on the Login")
	public void click_on_the_login() {
	    loginpage.clickOnbutton();
	  
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actulTitle=driver.getTitle();
		
		if(actulTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertTrue(false);
		}
	   
	}

	@When("User click on the Logout link")
	public void user_click_on_the_logout_link() {
	    
		loginpage.clickOnLogout();
	}

	@Then("close browser")
	public void close_browser() {
		
		driver.close();
	    
	}

}

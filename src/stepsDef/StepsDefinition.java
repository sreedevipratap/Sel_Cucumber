package stepsDef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsDefinition {
WebDriver driver;
	

@Given("^Open Chrome and start application$")
public void open_Chrome_and_start_application() throws Throwable {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://training.ie.kycnet.com");
	//driver.get("https://training.ie.kycnet.com");
}

@When("^I enter valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
//@When("^I enter valid javier van der meulen and password KYCnet(\\d+)$")
public void i_enter_valid_username_and_valid_password(String uname, String pwd) throws Throwable {
    //driver.findElement(By.xpath("//input[@name ='user_name']")).sendKeys("javier van der meulen");
    //driver.findElement(By.xpath("//input[@name ='user_pass']")).sendKeys("KYCnet123");
    //driver.findElement(By.xpath("//button[@id ='loginButton']")).click();
    
    driver.findElement(By.id("user_name")).sendKeys(uname);
    driver.findElement(By.id("user_pass")).sendKeys(pwd);
    driver.findElement(By.xpath("//button[@id ='loginButton']")).click();
   
}

@Then("^User should be able to login successfully and see the heading as \"([^\"]*)\"$")
public void user_should_be_able_to_login_successfully(String stractual) throws Throwable {
	//driver.findElement(By.xpath("//button[@id ='loginButton']")).click();
	
	String str = driver.findElement(By.xpath("//*[@id=\"mineReviews\"]/h2")).getText();
	//String stractual = "My reviews";
	Assert.assertEquals(str, stractual);
	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/ul/li[4]/a")).click();
	
}
@Then("^application should be closed$")
public void application_should_be_closed() throws Throwable {
	driver.quit();
}


}
